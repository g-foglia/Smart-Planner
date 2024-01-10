package org.gennisilv.smartplanner.data;

public class Impegno {
    String codiceImpegno;
    String nomeImpegno;
    int durataImpegno;
    int prioritaImpegno;

    public Impegno(String codiceImpegno, String nomeImpegno, int durataImpegno, int prioritaImpegno) {
        this.codiceImpegno = codiceImpegno;
        this.nomeImpegno = nomeImpegno;
        this.durataImpegno = durataImpegno;
        this.prioritaImpegno = prioritaImpegno;
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
}
