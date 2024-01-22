package org.gennisilv.smartplanner.data;

import java.util.GregorianCalendar;

public class Evento {
    private int codiceEvento;
    private String nomeEvento;
    private String descrizione;
    private String coloreEvento;
    private int periodicita;
    private boolean notifiche;
    private GregorianCalendar dataEvento;
    private String orarioInizio;
    private String orarioFine;
    private String emailE;

    public Evento() {
    }

    public Evento(String nomeEvento, String descrizione, String coloreEvento, int periodicita, boolean notifiche, GregorianCalendar dataEvento, String orarioInizio, String orarioFine, String emailE) {
        this.nomeEvento = nomeEvento;
        this.descrizione = descrizione;
        this.coloreEvento = coloreEvento;
        this.periodicita = periodicita;
        this.notifiche = notifiche;
        this.dataEvento = dataEvento;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.emailE = emailE;
    }

    public int getCodiceEvento() {
        return codiceEvento;
    }

    public void setCodiceEvento(int codiceEvento) {
        this.codiceEvento = codiceEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getColoreEvento() {
        return coloreEvento;
    }

    public void setColoreEvento(String coloreEvento) {
        this.coloreEvento = coloreEvento;
    }

    public int getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(int periodicita) {
        this.periodicita = periodicita;
    }

    public boolean isNotifiche() {
        return notifiche;
    }

    public void setNotifiche(boolean notifiche) {
        this.notifiche = notifiche;
    }

    public GregorianCalendar getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(GregorianCalendar dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getOrarioInizio() {
        return orarioInizio;
    }

    public void setOrarioInizio(String orarioInizio) {
        this.orarioInizio = orarioInizio;
    }

    public String getOrarioFine() {
        return orarioFine;
    }

    public void setOrarioFine(String orarioFine) {
        this.orarioFine = orarioFine;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }
}
