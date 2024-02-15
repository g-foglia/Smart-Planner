package org.gennisilv.smartplanner.test;
import javafx.scene.paint.Color;
import org.gennisilv.smartplanner.data.entity.Evento;
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
        e1.setNomeEvento("Progetto_esame");
        e1.setDescrizione("Descrizione dell'evento");
        e1.setOrarioInizio("13:30");
        e1.setOrarioFine("16:30");
        e1.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e1.setColoreEvento("#e0f0ff");
        e1.setNotifiche(true);
        e1.setPeriodicita(0);
        assertEquals(-4,EventoLogic.aggiungiEvento(e1.getNomeEvento(),e1.getDescrizione(),e1.getDataEvento(),e1.getOrarioInizio(),e1.getOrarioFine(), Color.valueOf(e1.getColoreEvento()),e1.isNotifiche(),e1.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoNomeVuoto(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e1 = new Evento();
        //check registrazione senza nome
        e1.setNomeEvento("");
        e1.setDescrizione("Descrizione dell'evento");
        e1.setOrarioInizio("13:30");
        e1.setOrarioFine("16:30");
        e1.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e1.setColoreEvento("#e0f0ff");
        e1.setNotifiche(true);
        e1.setPeriodicita(0);
        assertEquals(-4,EventoLogic.aggiungiEvento(e1.getNomeEvento(),e1.getDescrizione(),e1.getDataEvento(),e1.getOrarioInizio(),e1.getOrarioFine(), Color.valueOf(e1.getColoreEvento()),e1.isNotifiche(),e1.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoDescrizioneInvalida(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e2 = new Evento();
        //check registrazione senza nome
        e2.setNomeEvento("Progetto per esame");
        e2.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare in ottica di completare il progetto il prima possibile. Ci vedremo allo Starbucks sotto casa mia.");
        e2.setOrarioInizio("13:30");
        e2.setOrarioFine("16:30");
        e2.setDataEvento(DateConverter.toGregorianCalendar("29/02/2024"));
        e2.setColoreEvento("#e0f0ff");
        e2.setNotifiche(true);
        e2.setPeriodicita(0);
        assertEquals(-3,EventoLogic.aggiungiEvento(e2.getNomeEvento(), e2.getDescrizione(), e2.getDataEvento(), e2.getOrarioInizio(), e2.getOrarioFine(), Color.valueOf(e2.getColoreEvento()), e2.isNotifiche(), e2.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoDataAntecedente(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e3 = new Evento();
        //check registrazione senza nome
        e3.setNomeEvento("Progetto per esame");
        e3.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare per completare il progetto. Ci vedremo allo Starbucks sotto casa mia.");
        e3.setOrarioInizio("13:30");
        e3.setOrarioFine("16:30");
        e3.setDataEvento(DateConverter.toGregorianCalendar("08/12/2021"));
        e3.setColoreEvento("#e0f0ff");
        e3.setNotifiche(true);
        e3.setPeriodicita(0);
        assertEquals(-2,EventoLogic.aggiungiEvento(e3.getNomeEvento(), e3.getDescrizione(), e3.getDataEvento(), e3.getOrarioInizio(), e3.getOrarioFine(), Color.valueOf(e3.getColoreEvento()), e3.isNotifiche(), e3.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoDataVuota(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e3 = new Evento();
        //check registrazione senza nome
        e3.setNomeEvento("Progetto per esame");
        e3.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare per completare il progetto. Ci vedremo allo Starbucks sotto casa mia.");
        e3.setOrarioInizio("13:30");
        e3.setOrarioFine("16:30");
        e3.setDataEvento(null);
        e3.setColoreEvento("#e0f0ff");
        e3.setNotifiche(true);
        e3.setPeriodicita(0);
        assertEquals(-2,EventoLogic.aggiungiEvento(e3.getNomeEvento(), e3.getDescrizione(), e3.getDataEvento(), e3.getOrarioInizio(), e3.getOrarioFine(), Color.valueOf(e3.getColoreEvento()), e3.isNotifiche(), e3.getPeriodicita()));
    }
    @Test
    public void testInserimentoEventoOrarioAntecedente(){
        Evento e4 = new Evento();
        //check registrazione senza nome
        e4.setNomeEvento("Progetto per esame");
        e4.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare per completare il progetto. Ci vedremo allo Starbucks sotto casa mia.");
        e4.setOrarioInizio("18:00");
        e4.setOrarioFine("17:00");
        e4.setDataEvento(DateConverter.toGregorianCalendar("08/12/2024"));
        e4.setColoreEvento("#e0f0ff");
        e4.setNotifiche(true);
        e4.setPeriodicita(0);
        assertEquals(-1,EventoLogic.aggiungiEvento(e4.getNomeEvento(), e4.getDescrizione(), e4.getDataEvento(), e4.getOrarioInizio(), e4.getOrarioFine(), Color.valueOf(e4.getColoreEvento()), e4.isNotifiche(), e4.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoOrarioVuoto(){
        Evento e4 = new Evento();
        //check registrazione senza nome
        e4.setNomeEvento("Progetto per esame");
        e4.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare per completare il progetto. Ci vedremo allo Starbucks sotto casa mia.");
        e4.setOrarioInizio("null:null");
        e4.setOrarioFine("null:null");
        e4.setDataEvento(DateConverter.toGregorianCalendar("08/12/2024"));
        e4.setColoreEvento("#e0f0ff");
        e4.setNotifiche(true);
        e4.setPeriodicita(0);
        assertEquals(-1,EventoLogic.aggiungiEvento(e4.getNomeEvento(), e4.getDescrizione(), e4.getDataEvento(), e4.getOrarioInizio(), e4.getOrarioFine(), Color.valueOf(e4.getColoreEvento()), e4.isNotifiche(), e4.getPeriodicita()));
    }

    @Test
    public void testInserimentoEventoEffettuato(){
        UtenteLogic.login("silvanacafaro256@gmail.com","Zzilv1234!");
        Evento e4 = new Evento();
        //check registrazione senza nome
        e4.setNomeEvento("Progetto per esame");
        e4.setDescrizione("Dopo la normale sessione di studio mi vedrò con le mie due compagne per discutere i prossimi passi da fare per completare il progetto. Ci vedremo allo Starbucks sotto casa mia.");
        e4.setOrarioInizio("14.30");
        e4.setOrarioFine("16.30");
        e4.setDataEvento(DateConverter.toGregorianCalendar("29/12/2024"));
        e4.setColoreEvento("#e0f0ff");
        e4.setNotifiche(true);
        e4.setPeriodicita(0);
        assertEquals(12, EventoLogic.aggiungiEvento(e4.getNomeEvento(), e4.getDescrizione(), e4.getDataEvento(), e4.getOrarioInizio(), e4.getOrarioFine(), Color.valueOf(e4.getColoreEvento()), e4.isNotifiche(), e4.getPeriodicita()));
    }

}

