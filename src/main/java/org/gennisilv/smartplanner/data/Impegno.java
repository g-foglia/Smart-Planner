package org.gennisilv.smartplanner.data;

public class Impegno {
    private String codiceImpegno;
    private String nomeImpegno;
    private int durataImpegno;
    private int prioritaImpegno;
    private String emailUI;

    public Impegno() {
    }

    public Impegno(String codiceImpegno, String nomeImpegno, int durataImpegno, int prioritaImpegno, String emailUI) {
        this.codiceImpegno = codiceImpegno;
        this.nomeImpegno = nomeImpegno;
        this.durataImpegno = durataImpegno;
        this.prioritaImpegno = prioritaImpegno;
        this.emailUI = emailUI;
    }

    public String getCodiceImpegno() {
        return codiceImpegno;
    }

    public void setCodiceImpegno(String codiceImpegno) {
        this.codiceImpegno = codiceImpegno;
    }

    public String getNomeImpegno() {
        return nomeImpegno;
    }

    public void setNomeImpegno(String nomeImpegno) {
        this.nomeImpegno = nomeImpegno;
    }

    public int getDurataImpegno() {
        return durataImpegno;
    }

    public void setDurataImpegno(int durataImpegno) {
        this.durataImpegno = durataImpegno;
    }

    public int getPrioritaImpegno() {
        return prioritaImpegno;
    }

    public void setPrioritaImpegno(int prioritaImpegno) {
        this.prioritaImpegno = prioritaImpegno;
    }

    public String getEmailUI() {
        return emailUI;
    }

    public void setEmailUI(String emailUI) {
        this.emailUI = emailUI;
    }
}
