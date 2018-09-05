package com.zakupkigovru.date;

import java.time.LocalDate;

public class DateUtil {
    public static LocalDate stringToDate(String stringDate, DateFormat format) {
        return LocalDate.parse(stringDate, format.getDateTimeFormatter());
    }

    public static String dateToString(LocalDate date, DateFormat format) {
        return date.format(format.getDateTimeFormatter());
    }
}
