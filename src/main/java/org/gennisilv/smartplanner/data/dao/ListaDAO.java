package org.gennisilv.smartplanner.data.dao;


import org.gennisilv.smartplanner.data.ConPool;
import org.gennisilv.smartplanner.data.entity.Impegno;
import org.gennisilv.smartplanner.data.entity.Lista;

import java.sql.*;
import java.util.ArrayList;

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
    public static int doAddImpegno(Impegno impegno){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO impegno (impegno.codiceImpegno, nomeImpegno, durataImpegno, prioritaImpegno, emailUI) VALUES(null,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, impegno.getNomeImpegno());
            ps.setInt(2,impegno.getDurataImpegno());
            ps.setInt(3,impegno.getPrioritaImpegno());
            ps.setString(4, impegno.getEmailUI());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
            else{
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
    public static void doClearLista(String email){
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

    public static ArrayList<Impegno> doGetLista(String email){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * from impegno WHERE emailUI=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            ArrayList<Impegno> impegni = new ArrayList<>();
            while(rs.next()){
                Impegno impegno = new Impegno();
                impegno.setCodiceImpegno(rs.getInt(1));
                impegno.setNomeImpegno(rs.getString(2));
                impegno.setDurataImpegno(rs.getInt(3));
                impegno.setPrioritaImpegno(rs.getInt(4));
                impegno.setEmailUI(rs.getString(5));

                impegni.add(impegno);
            }

            return impegni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Impegno doRetrieveImpegno(int codiceImpegno){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * from impegno WHERE codiceImpegno=?");
            ps.setInt(1,codiceImpegno);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Impegno impegno = new Impegno();
                impegno.setCodiceImpegno(rs.getInt(1));
                impegno.setNomeImpegno(rs.getString(2));
                impegno.setDurataImpegno(rs.getInt(3));
                impegno.setPrioritaImpegno(rs.getInt(4));
                impegno.setEmailUI(rs.getString(5));

                return impegno;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
