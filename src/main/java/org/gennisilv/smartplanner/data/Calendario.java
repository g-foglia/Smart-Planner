package org.gennisilv.smartplanner.data;

public class Calendario {
    private int codiceCalendario;
    private String nomeCalendario;
    private String coloreCalendario;

    public Calendario() {
    }

    public Calendario(String nomeCalendario, String coloreCalendario) {
        this.nomeCalendario = nomeCalendario;
        this.coloreCalendario = coloreCalendario;
    }

    public int getCodiceCalendario() {
        return codiceCalendario;
    }

    public void setCodiceCalendario(int codiceCalendario) {
        this.codiceCalendario = codiceCalendario;
    }

    public String getNomeCalendario() {
        return nomeCalendario;
    }

    public void setNomeCalendario(String nomeCalendario) {
        this.nomeCalendario = nomeCalendario;
    }

    public String getColoreCalendario() {
        return coloreCalendario;
    }

    public void setColoreCalendario(String coloreCalendario) {
        this.coloreCalendario = coloreCalendario;
    }
}
