package org.gennisilv.smartplanner.utils;

public class DataHolder {
    private String string;
    private int integer;
    private final static DataHolder ISTANZA = new DataHolder();

    private DataHolder(){}

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public static DataHolder getIstanza(){
        return ISTANZA;
    }
}
