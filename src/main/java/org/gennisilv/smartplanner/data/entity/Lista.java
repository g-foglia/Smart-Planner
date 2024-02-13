package org.gennisilv.smartplanner.data.entity;

public class Lista {
    private String emailUL;
    private String coloreLista;

    public Lista() {
    }

    public Lista(String emailUL, String coloreLista) {
        this.emailUL = emailUL;
        this.coloreLista = coloreLista;
    }

    public String getEmailUL() {
        return emailUL;
    }

    public void setEmailUL(String emailUL) {
        this.emailUL = emailUL;
    }

    public String getColoreLista() {
        return coloreLista;
    }

    public void setColoreLista(String coloreLista) {
        this.coloreLista = coloreLista;
    }
}
