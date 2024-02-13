package org.gennisilv.smartplanner.test;
import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.logic.EventoLogic;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.DateConverter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class InserimentoEventoTest {

@Test
    public void testInserimentoEventoNomeInvalido(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e1 = new Evento();
        //check registrazione senza nome
        e1.setNomeEvento("Nome_Evento");
        e1.setDescrizione("Descrizione dell'evento");
        e1.setOrarioInizio("13.30");
        e1.setOrarioFine("16.30");
        e1.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e1.setColoreEvento("#e0f0ff");
        e1.setNotifiche(true);
        e1.setPeriodicita(0);
        assertEquals(1,EventoLogic.aggiungiEvento(e1.getNomeEvento(),e1.getDescrizione(),e1.getDataEvento(),e1.getOrarioInizio(),e1.getOrarioFine(), Color.valueOf(e1.getColoreEvento()),e1.isNotifiche(),e1.getPeriodicita()));
    }
    @Test
    public void testInserimentoEventoDescrizioneInvalida(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e2 = new Evento();
        //check registrazione senza nome
        e2.setNomeEvento("NomeEvento2");
        e2.setDescrizione("test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test ");
        e2.setOrarioInizio("13.30");
        e2.setOrarioFine("16.30");
        e2.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e2.setColoreEvento("#e0f0ff");
        e2.setNotifiche(true);
        e2.setPeriodicita(0);
        assertEquals(1,EventoLogic.aggiungiEvento(e2.getNomeEvento(), e2.getDescrizione(), e2.getDataEvento(), e2.getOrarioInizio(), e2.getOrarioFine(), Color.valueOf(e2.getColoreEvento()), e2.isNotifiche(), e2.getPeriodicita()));
    }
    @Test
    public void testInserimentoEventoDataAntecedente(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e3 = new Evento();
        //check registrazione senza nome
        e3.setNomeEvento("NomeEvento3");
        e3.setDescrizione("Descrizione Test");
        e3.setOrarioInizio("13.30");
        e3.setOrarioFine("16.30");
        e3.setDataEvento(DateConverter.toGregorianCalendar("29/01/2024"));
        e3.setColoreEvento("#e0f0ff");
        e3.setNotifiche(true);
        e3.setPeriodicita(0);
        assertEquals(1,EventoLogic.aggiungiEvento(e3.getNomeEvento(), e3.getDescrizione(), e3.getDataEvento(), e3.getOrarioInizio(), e3.getOrarioFine(), Color.valueOf(e3.getColoreEvento()), e3.isNotifiche(), e3.getPeriodicita()));
    }
    @Test
    public void testInserimentoEventoOrarioAntecedente(){
        Evento e4 = new Evento();
        //check registrazione senza nome
        e4.setNomeEvento("NomeEvento4");
        e4.setDescrizione("Descrizione Test");
        e4.setOrarioInizio("14.30");
        e4.setOrarioFine("12.30");
        e4.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e4.setColoreEvento("#e0f0ff");
        e4.setNotifiche(true);
        e4.setPeriodicita(0);
        assertEquals(1,EventoLogic.aggiungiEvento(e4.getNomeEvento(), e4.getDescrizione(), e4.getDataEvento(), e4.getOrarioInizio(), e4.getOrarioFine(), Color.valueOf(e4.getColoreEvento()), e4.isNotifiche(), e4.getPeriodicita()));
    }
    @Test
    public void testInserimentoEventoEffettuato(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e4 = new Evento();
        //check registrazione senza nome
        e4.setNomeEvento("NomeEvento5");
        e4.setDescrizione("Descrizione Test");
        e4.setOrarioInizio("14.30");
        e4.setOrarioFine("16.30");
        e4.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e4.setColoreEvento("#e0f0ff");
        e4.setNotifiche(true);
        e4.setPeriodicita(0);
        assertEquals(1, EventoLogic.aggiungiEvento(e4.getNomeEvento(), e4.getDescrizione(), e4.getDataEvento(), e4.getOrarioInizio(), e4.getOrarioFine(), Color.valueOf(e4.getColoreEvento()), e4.isNotifiche(), e4.getPeriodicita()));
    }

}

