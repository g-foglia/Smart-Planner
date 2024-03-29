package org.gennisilv.smartplanner.logic;

import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.entity.Impegno;
import org.gennisilv.smartplanner.data.entity.Lista;
import org.gennisilv.smartplanner.data.dao.ListaDAO;
import org.gennisilv.smartplanner.utils.ColorConverter;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ListaLogic {
    public static void creaLista(Color colore, ArrayList<Impegno> impegni){
        Lista lista = new Lista(UtenteLogic.returnLoggedInUser().getEmail(), ColorConverter.toHexString(colore));
        ListaDAO.doSaveLista(lista);

        for(Impegno impegno : impegni)
            ListaDAO.doAddImpegno(impegno);
    }

    public static void creaLista(Color colore){
        Lista lista = new Lista(UtenteLogic.returnLoggedInUser().getEmail(), ColorConverter.toHexString(colore));
        ListaDAO.doSaveLista(lista);
    }

    public static int aggiungiImpegno(String nomeImpegno, int durataImpegno, int prioritaImpegno) {
        Impegno impegno;
        /*
            CONTROLLI SUI CAMPI
        */
        if (!nomeImpegno.isEmpty() && !checkName(nomeImpegno))
            if (durataImpegno != 0 && checkDurata(durataImpegno)) {
                impegno = new Impegno(nomeImpegno, durataImpegno, prioritaImpegno, UtenteLogic.returnLoggedInUser().getEmail());
                return ListaDAO.doAddImpegno(impegno);
            } else {
                return -1;
            }
        else{
            return -2;
        }
    }

    public static ArrayList<Impegno> getLista(){
        return ListaDAO.doGetLista(UtenteLogic.returnLoggedInUser().getEmail());
    }

    public static void svuotaLista(){
        ListaDAO.doClearLista(UtenteLogic.returnLoggedInUser().getEmail());
    }

    public static void cancellaImpegno(int codiceImpegno){
        ListaDAO.doCancImpegno(codiceImpegno);
    }

    public static Impegno getImpegno(int codiceImpegno){
        return ListaDAO.doRetrieveImpegno(codiceImpegno);
    }

    private static boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z0-9\\s]").matcher(nome).find();
    }
    private static boolean checkDurata(int durataImpegno) {
        if (durataImpegno < 30) return false;
        else
            return true;
    }
}



