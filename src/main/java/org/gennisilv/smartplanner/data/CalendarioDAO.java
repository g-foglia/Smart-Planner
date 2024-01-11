package org.gennisilv.smartplanner.data;

import org.gennisilv.smartplanner.utils.ConPool;
import java.sql.*;


//si occupa delle operazioni che riguardano il calendario (inserimento e cancellazione di un evento, creazione modifica e cancellazione di un calendario)
public class CalendarioDAO {

    //salva un nuovo calendario nel db
    public static void doSaveCalendario(Calendario calendario, String emailC) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Calendario (codiceCalendario, nomeCalendario, coloreCalendario) VALUES(?,?,?)");
            ps.setString(1, calendario.getCodiceCalendario());
            ps.setString(2,calendario.getNomeCalendario());
            ps.setString(3, calendario.getColoreCalendario());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ps = con.prepareStatement("INSERT INTO creazione (emailC, codiceCalendarioC) VALUES(?,?)");
            ps.setString(1, emailC);
            ps.setString(2, calendario.getCodiceCalendario());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //cancella un calendario dal db (e con esso tutti gli eventi associati a meno che non appaiano anche in altri calendari)
    public static void doCancCalendario(String codiceCalendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Calendario where codiceCalendario=?");
            ps.setString(1, codiceCalendario);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //restituisce un calendario cercato per codice, se esiste
    public static Calendario doRetrieveByCodice(String codiceCalendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT nomeCalendario, coloreCalendario FROM calendario WHERE codiceCalendario=?");
            ps.setString(1, codiceCalendario);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String nomeCalendario = rs.getString(1);
                String coloreCalendario = rs.getString(2);
                Calendario calendario = new Calendario(codiceCalendario, nomeCalendario, coloreCalendario);
                return calendario;
            }
            return null;

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
            ps.setString(3, calendario.getCodiceCalendario());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //aggiunge un evento al calendario
    public static void doAddEvento(String codiceEvento, String codiceCalendario){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO inserimento (codiceCalendarioI, codiceEventoI) VALUES (?,?)");
            ps.setString(1,codiceCalendario);
            ps.setString(2,codiceEvento);

            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error.");
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //rimuove un evento da uno specifico calendario
    public static void doRemoveEvento(String codiceEvento, String codiceCalendario){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM inserimento where codiceCalendarioI=? AND codiceEventoI=?");
            ps.setString(1, codiceCalendario);
            ps.setString(2, codiceEvento);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
