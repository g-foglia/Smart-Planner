package org.gennisilv.smartplanner.logic;

import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.data.CalendarioDAO;
import org.gennisilv.smartplanner.utils.ColorConverter;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.util.ArrayList;

public class CalendarioLogic {
    public static void creaCalendario(String nome, Color color){
        CalendarioDAO.doSaveCalendario(new Calendario(nome, ColorConverter.toHexString(color)), UserHolder.getIstanza().getUtente().getEmail());
    }

    public static Calendario cercaCalendario(String nome){
        return CalendarioDAO.doRetrieveByNome(nome,UtenteLogic.returnLoggedInUser().getEmail());
    }

    public static ArrayList<Calendario> returnCalendari(){
        return CalendarioDAO.doRetrieveByUtente(UtenteLogic.returnLoggedInUser().getEmail());
    }

    public static void aggiungiEvento(int codiceEvento, int codiceCalendario){
        CalendarioDAO.doAddEvento(codiceEvento,codiceCalendario);
    }
}