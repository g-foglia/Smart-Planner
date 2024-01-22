package org.gennisilv.smartplanner.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//si occupa delle operazioni che riguardano la lista (aggiunta e rimozione di impegni, creazione e modifica del colore della lista)
public class ListaDAO {

    //crea la lista per l'utente
    public static void doSaveLista(Lista lista){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO lista (emailUL, coloreLista) VALUES(?,?)");
            ps.setString(1, lista.getEmailUL());
            ps.setString(2, lista.getColoreLista());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //aggiunge un impegno a una lista
    public static void doAddImpegno(Impegno impegno){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO impegno (null, nomeImpegno, durataImpegno, prioritaImpegno, emailUI) VALUES(?,?,?,?,?)");
            ps.setString(1, impegno.getNomeImpegno());
            ps.setInt(2,impegno.getDurataImpegno());
            ps.setInt(3,impegno.getPrioritaImpegno());
            ps.setString(4, impegno.getEmailUI());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //rimuove un impegno
    public static void doCancImpegno(int codiceImpegno){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE  FROM impegno WHERE codiceImpegno=?");
            ps.setInt(1, codiceImpegno);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //svuota la lista
    public void doClearLista(String email){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM impegno WHERE emailUI=?");
            ps.setString(1, email);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
