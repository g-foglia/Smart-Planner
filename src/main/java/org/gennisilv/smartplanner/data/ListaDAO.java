package org.gennisilv.smartplanner.data;


import org.gennisilv.smartplanner.utils.ConPool;

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

    /*AGGIUNGERE
      EMAILUI
      APPENA
      MESSA
      NEL
      DB
     */
    public static void doAddImpegno(Impegno impegno, String emailUL){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO impegno (codiceImpegno, nomeImpegno, durataImpegno, prioritaImpegno) VALUES(?,?,?,?)");
            ps.setString(1, impegno.getCodiceImpegno());
            ps.setString(2, impegno.getNomeImpegno());
            ps.setInt(3,impegno.getDurataImpegno());
            ps.setInt(4,impegno.getPrioritaImpegno());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //rimuove un impegno
    public static void doCancImpegno(String codiceImpegno){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE  FROM impegno WHERE codiceImpegno=?");
            ps.setString(1, codiceImpegno);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //svuota la lista
    public void doClearLista(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "TRUNCATE impegno");
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
