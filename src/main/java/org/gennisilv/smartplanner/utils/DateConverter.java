package org.gennisilv.smartplanner.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class DateConverter {
    public static GregorianCalendar toGregorianCalendar(String date){
        GregorianCalendar data = new GregorianCalendar(Integer.parseInt(date.substring(6)),Integer.parseInt(date.substring(3,5))-1,Integer.parseInt(date.substring(0,2)));
        return data;
    }

    public static String toString(GregorianCalendar date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String data = fmt.format(date.getTime());
        return data;
    }

    public static LocalDate toLocalDate(GregorianCalendar date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String dataTemp = fmt.format(date.getTime());
        LocalDate data = LocalDate.of(Integer.parseInt(dataTemp.substring(6)),Integer.parseInt(dataTemp.substring(3,5)),Integer.parseInt(dataTemp.substring(0,2)));
        return data;
    }
}
