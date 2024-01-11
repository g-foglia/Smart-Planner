package org.gennisilv.smartplanner.data;

import org.gennisilv.smartplanner.utils.ConPool;
import org.gennisilv.smartplanner.utils.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//si occupa delle operazioni che riguardano gli utenti (login, registrazione, cancellazione e ricerca per email)
public class UtenteDAO {

    //login
    public static Utente login(String email, String password){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE email=? AND password_=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Utente utente = new Utente();
                utente.setEmail(rs.getString(1));
                utente.setPassword(rs.getString(2));
                utente.setNome(rs.getString(3));
                utente.setCognome(rs.getString(4));
                utente.setUsername(rs.getString(5));
                utente.setDataDiNascita(DateConverter.toGregorianCalendar(rs.getString(6)));

                return utente;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //registrazione di un nuovo utente
    public static void doAddUtente(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Utente (email, password_, nome, cognome, username, dataDiNascita) VALUES(?,?,?,?,?,?)");
            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getNome());
            ps.setString(4, utente.getCognome());
            ps.setString(5, utente.getUsername());
            ps.setString(6, DateConverter.toString(utente.getDataDiNascita()));

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //cancellazione di un utente
    public static void doCancUtente(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Utente WHERE email=?");
            ps.setString(1, email);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //restituisce un utente cercato per email, se esiste
    public static Utente doRetrieveByEmail(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM utente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Utente utente = new Utente();
                utente.setEmail(rs.getString(1));
                utente.setPassword(rs.getString(2));
                utente.setNome(rs.getString(3));
                utente.setCognome(rs.getString(4));
                utente.setUsername(rs.getString(5));
                utente.setDataDiNascita(DateConverter.toGregorianCalendar(rs.getString(6)));

                return utente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
