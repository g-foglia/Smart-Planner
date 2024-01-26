package org.gennisilv.smartplanner.data;

import java.sql.*;
import java.util.ArrayList;


//si occupa delle operazioni che riguardano il calendario (inserimento e cancellazione di un evento, creazione modifica e cancellazione di un calendario)
public class CalendarioDAO {

    //salva un nuovo calendario nel db
    public static int doSaveCalendario(Calendario calendario, String emailC) {
        try (Connection con = ConPool.getConnection()) {

            //aggiungo il calendario alla tabella calendario
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Calendario (codiceCalendario, nomeCalendario, coloreCalendario) VALUES(null,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,calendario.getNomeCalendario());
            ps.setString(2, calendario.getColoreCalendario());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            //mi faccio restituire la riga della tabella che corrisponde al nuovo calendario
            ResultSet rs = ps.getGeneratedKeys();

            //aggiungo l'associaizone tra il codice del nuovo calendario e l'utente che lo ha creato
            if(rs.next()) {
                int codiceCalendario = rs.getInt(1);
                ps = con.prepareStatement("INSERT INTO creazione (emailC, codiceCalendarioC) VALUES(?,?)");
                ps.setString(1, emailC);
                ps.setInt(2, codiceCalendario);
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
                return codiceCalendario;
            }
            else{
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //cancella un calendario dal db (e con esso tutti gli eventi associati a meno che non appaiano anche in altri calendari)
    public static void doCancCalendario(int codiceCalendario, String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Calendario where codiceCalendario=? AND codiceCalendario in (SELECT codiceCalendarioC from creazione WHERE emailC=?)");
            ps.setInt(1, codiceCalendario);
            ps.setString(2, email);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //restituisce un calendario cercato per codice, se esiste
    public static Calendario doRetrieveByCodice(int codiceCalendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT nomeCalendario, coloreCalendario FROM calendario WHERE codiceCalendario=?");
            ps.setInt(1, codiceCalendario);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setCodiceCalendario(codiceCalendario);
                calendario.setNomeCalendario(rs.getString(1));
                calendario.setColoreCalendario(rs.getString(2));
                return calendario;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Calendario doRetrieveByNome(String nomeCalendario, String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM calendario WHERE nomeCalendario=? AND codiceCalendario IN (SELECT codiceCalendarioC FROM creazione WHERE emailC=?)");
            ps.setString(1, nomeCalendario);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setCodiceCalendario(rs.getInt(1));
                calendario.setNomeCalendario(rs.getString(2));
                calendario.setColoreCalendario(rs.getString(3));
                return calendario;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Calendario> doRetrieveByUtente(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM calendario WHERE codiceCalendario in (SELECT codiceCalendarioC FROM creazione WHERE emailC=?)");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            ArrayList<Calendario> calendari = new ArrayList<>();
            while(rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setCodiceCalendario(rs.getInt(1));
                calendario.setNomeCalendario(rs.getString(2));
                calendario.setColoreCalendario(rs.getString(3));

                calendari.add(calendario);
            }
            return calendari;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //aggiorna gli attributi di un calendario ricercato per codice
    public static void doUpdateCalendario(Calendario calendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE calendario SET nomeCalendario=?, coloreCalendario=? WHERE codiceCalendario=?");

            ps.setString(1, calendario.getNomeCalendario());
            ps.setString(2, calendario.getColoreCalendario());
            ps.setInt(3, calendario.getCodiceCalendario());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //aggiunge un evento al calendario
    public static void doAddEvento(int codiceEvento, int codiceCalendario){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO inserimento (codiceCalendarioI, codiceEventoI) VALUES (?,?)");
            ps.setInt(1,codiceCalendario);
            ps.setInt(2,codiceEvento);

            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error.");
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //rimuove un evento da uno specifico calendario
    public static void doRemoveEvento(int codiceEvento, int codiceCalendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM inserimento where codiceCalendarioI=? AND codiceEventoI=?");
            ps.setInt(1, codiceCalendario);
            ps.setInt(2, codiceEvento);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
