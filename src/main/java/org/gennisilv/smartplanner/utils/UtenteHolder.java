package org.gennisilv.smartplanner.utils;

import org.gennisilv.smartplanner.data.Utente;

public class UtenteHolder {
    private Utente utente;
    private final static UtenteHolder ISTANZA = new UtenteHolder();

    private UtenteHolder(){}

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public static UtenteHolder getIstanza(){
        return ISTANZA;
    }
}
