package org.gennisilv.smartplanner.utils;

import org.gennisilv.smartplanner.data.Utente;

public class UserHolder {
    private Utente utente;
    private final static UserHolder ISTANZA = new UserHolder();

    private UserHolder(){}

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public static UserHolder getIstanza(){
        return ISTANZA;
    }
}
