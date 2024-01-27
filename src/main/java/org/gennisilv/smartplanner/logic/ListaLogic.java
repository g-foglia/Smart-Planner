package org.gennisilv.smartplanner.logic;

import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.Impegno;
import org.gennisilv.smartplanner.data.Lista;
import org.gennisilv.smartplanner.data.ListaDAO;
import org.gennisilv.smartplanner.utils.ColorConverter;

import java.util.ArrayList;

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

    public static int aggiungiImpegno(String nomeImpegno, int durataImpegno, int prioritaImpegno){
        Impegno impegno = new Impegno(nomeImpegno,durataImpegno,prioritaImpegno,
                UtenteLogic.returnLoggedInUser().getEmail());

        return ListaDAO.doAddImpegno(impegno);
    }

    public static void svuotaLista(){
        ListaDAO.doClearLista(UtenteLogic.returnLoggedInUser().getEmail());
    }

    public static void cancellaImpegno(int codiceImpegno){
        ListaDAO.doCancImpegno(codiceImpegno);
    }
}
