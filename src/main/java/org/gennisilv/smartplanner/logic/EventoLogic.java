package org.gennisilv.smartplanner.logic;

import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.entity.Evento;
import org.gennisilv.smartplanner.data.dao.EventoDAO;
import org.gennisilv.smartplanner.utils.ColorConverter;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class EventoLogic {
    public static int aggiungiEvento(String nome, String descrizione, GregorianCalendar data, String oraInizio, String oraFine, Color colore, boolean notifiche, int periodicita){
        if(!checkName(nome))
            if(lunghezza(descrizione))
                if(!date(data))
                    if(checkTimeE(oraInizio,oraFine)){
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
                    else{
                        //orario di fine antecedente alla orario di inizio
                        return 1;
                    }
                else{
                    //data dell'evento appartenente al passato
                    return 2;
                }
            else{
                //descrizione troppo lunga
                return 3;
            }
        else{
            //nome che contiene caratteri speciali
            return 4;
        }

    }

    public static ArrayList<Evento> ricercaEvento(String nome, String email){
        return EventoDAO.doRetrieveEventsByName(nome, email);
    }

    private static boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z0-9]").matcher(nome).find();
    }

    private static boolean lunghezza(String descrizione){
        if(descrizione.length() > 200)
            return false;
        return true;
    }

    //non funziona
    private static boolean date(GregorianCalendar data){
        GregorianCalendar dataAttuale = new GregorianCalendar();

        return data.before(dataAttuale);
    }

    private static boolean checkTimeE(String oraI, String oraF){
        int oraInizio = Integer.parseInt(oraI.substring(0,2));
        int oraFine = Integer.parseInt(oraF.substring(0,2));

        if(oraFine < oraInizio)
            return false;
        else if(oraFine == oraInizio){
            int minutiInizio = Integer.parseInt(oraI.substring(3));
            int minutiFine = Integer.parseInt(oraF.substring(3));

            if(minutiFine < minutiInizio)
                return false;
        }
        return true;
    }
}
