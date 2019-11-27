package be.volders.vaccinapp.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    private final static String FORMAT = "dd/MM/yyyy";

    public static Date parse(String date) {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT, Locale.FRENCH);
        Date parsed;

        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            parsed = null;
            e.printStackTrace();
        }

        return parsed;
    }

    public static Date getDate(String date) {
        return parse(date);
    }

}
