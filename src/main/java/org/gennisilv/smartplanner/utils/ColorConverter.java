package org.gennisilv.smartplanner.utils;

import javafx.scene.paint.Color;

public class ColorConverter {
    //due metodi per la conversione dell'oggetto Color in una stringa esadecimale.
    //NON funzionano per TUTTI i colori possibili, ma sono abbastanza affidabili
    private static String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public static String toHexString(Color value) {
        return (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()))
                .toUpperCase();
    }
}
