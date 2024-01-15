package org.gennisilv.smartplanner.data;

import org.gennisilv.smartplanner.utils.ConPool;
import org.gennisilv.smartplanner.utils.DateConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//si occupa delle operazioni che riguardano gli eventi(creazione, cancellazione, modifica)
public class EventoDAO {

    //aggiunge un unovo evento al db
    public static void doSaveEvento(Evento evento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Evento (codiceEvento, nomeEvento, descrizione, coloreEvento, periodicita, notifiche, dataEvento, orarioInizio, orarioFine, emailE) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, evento.getCodiceEvento());
            ps.setString(2, evento.getNomeEvento());
            ps.setString(3, evento.getDescrizione());
            ps.setString(4, evento.getColoreEvento());
            ps.setInt(5, evento.getPeriodicita());
            ps.setBoolean(6, evento.isNotifiche());
            ps.setString(7, DateConverter.toString(evento.getDataEvento()));
            ps.setString(8, evento.getOrarioInizio());
            ps.setString(9, evento.getOrarioFine());
            ps.setString(10, evento.getEmailE());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //aggiorna i valori degli attributi di un evento
    public static void doUpdateEvento(Evento evento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE Evento SET nomeEvento=?, descrizione=?, coloreEvento=?, periodicita=?, notifiche=?, dataEvento=?, orarioInizio=?, orarioFine=? WHERE codiceEvento=?");
            ps.setString(1, evento.getNomeEvento());
            ps.setString(2, evento.getDescrizione());
            ps.setString(3, evento.getColoreEvento());
            ps.setInt(4, evento.getPeriodicita());
            ps.setBoolean(5, evento.isNotifiche());
            ps.setString(6, DateConverter.toString(evento.getDataEvento()));
            ps.setString(7, evento.getOrarioInizio());
            ps.setString(8, evento.getOrarioFine());
            ps.setString(9, evento.getCodiceEvento());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //restituisce tutti gli eventi corrispondenti a un certo nome
    public static List<Evento> doRetrieveEventsByName(String nomeEvento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM evento WHERE nomeEvento=?");
            ps.setString(1, nomeEvento);
            ResultSet rs = ps.executeQuery();

            List<Evento> eventi = new ArrayList<>();
            while(rs.next()) {
                Evento evento = new Evento();
                evento.setCodiceEvento(rs.getString(1));
                evento.setNomeEvento(rs.getString(2));
                evento.setDescrizione(rs.getString(3));
                evento.setColoreEvento(rs.getString(4));
                evento.setPeriodicita(rs.getInt(5));
                evento.setNotifiche(rs.getBoolean(6));
                evento.setDataEvento(DateConverter.toGregorianCalendar(rs.getString(7)));
                evento.setOrarioInizio(rs.getString(8));
                evento.setOrarioFine(rs.getString(9));
                evento.setEmailE(rs.getString(10));

                eventi.add(evento);
            }
            return eventi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //restituisce l'evento corrispondente a un certo codice, se esiste
    public static Evento doRetrieveEventByCode(String codiceEvento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM evento WHERE codiceEvento=?");
            ps.setString(1, codiceEvento);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Evento evento = new Evento();
                evento.setCodiceEvento(rs.getString(1));
                evento.setNomeEvento(rs.getString(2));
                evento.setDescrizione(rs.getString(3));
                evento.setColoreEvento(rs.getString(4));
                evento.setPeriodicita(rs.getInt(5));
                evento.setNotifiche(rs.getBoolean(6));
                evento.setDataEvento(DateConverter.toGregorianCalendar(rs.getString(7)));
                evento.setOrarioInizio(rs.getString(8));
                evento.setOrarioFine(rs.getString(9));
                evento.setEmailE(rs.getString(10));

                return evento;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //rimuove un evento da tutti i calendari
    public static void doCancEvento(String codiceEvento){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM evento where codiceEvento=?");
            ps.setString(1, codiceEvento);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
