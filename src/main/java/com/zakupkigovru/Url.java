package com.zakupkigovru;

import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class Url {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Integer pageNumber;
    private FederalLaw law;
    private LocalDate date;


    @Override
    public String toString() {
        String stringDate = date.format(formatter);
        return "http://www.zakupki.gov.ru/epz/order/extendedsearch/rss?pageNumber=" + pageNumber + "&" + law.getLaw() + "&publishDateFrom=" + stringDate + "&publishDateTo=" + stringDate;
    }
}