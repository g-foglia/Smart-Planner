package org.gennisilv.smartplanner.logic;

import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.data.EventoDAO;
import org.gennisilv.smartplanner.utils.ColorConverter;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EventoLogic {
    public static int aggiungiEvento(String nome, String descrizione, GregorianCalendar data, String oraInizio, String oraFine, Color colore, boolean notifiche, int periodicita){
        Evento evento = new Evento();

        evento.setNomeEvento(nome);
        evento.setDescrizione(descrizione);
        evento.setDataEvento(data);
        evento.setOrarioInizio(oraInizio);
        evento.setOrarioFine(oraFine);
        evento.setColoreEvento(ColorConverter.toHexString(colore));
        evento.setNotifiche(notifiche);
        evento.setPeriodicita(3);
        evento.setPeriodicita(periodicita);
        evento.setEmailE(UtenteLogic.returnLoggedInUser().getEmail());
        return EventoDAO.doSaveEvento(evento);
    }

    public static ArrayList<Evento> ricercaEvento(String nome, String email){
        return EventoDAO.doRetrieveEventsByName(nome, email);
    }
}
