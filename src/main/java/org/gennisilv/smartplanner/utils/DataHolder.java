package org.gennisilv.smartplanner.utils;

public class DataHolder {
    private String data;
    private final static DataHolder ISTANZA = new DataHolder();

    private DataHolder(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static DataHolder getIstanza(){
        return ISTANZA;
    }
}
