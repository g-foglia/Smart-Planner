package org.gennisilv.smartplanner.data;

public class Calendario {
    private String codiceCalendario;
    private String nomeCalendario;
    private String coloreCalendario;

    public Calendario() {
    }

    public Calendario(String codiceCalendario, String nomeCalendario, String coloreCalendario) {
        this.codiceCalendario = codiceCalendario;
        this.nomeCalendario = nomeCalendario;
        this.coloreCalendario = coloreCalendario;
    }

    public String getCodiceCalendario() {
        return codiceCalendario;
    }

    public void setCodiceCalendario(String codiceCalendario) {
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
