package org.gennisilv.smartplanner.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateConverter {
    public static GregorianCalendar toGregorianCalendar(String date){
        GregorianCalendar data = new GregorianCalendar(Integer.parseInt(date.substring(6)),Integer.parseInt(date.substring(3,5))-1,Integer.parseInt(date.substring(0,2)));
        return data;
    }

    public static String toString(GregorianCalendar date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yy");
        String data = fmt.format(date);
        return data;
    }
}
