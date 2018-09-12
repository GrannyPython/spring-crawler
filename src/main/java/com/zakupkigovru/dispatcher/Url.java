package com.zakupkigovru.dispatcher;

import com.zakupkigovru.FederalLaw;
import com.zakupkigovru.date.DateFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Url {

    private Integer pageNumber;
    private FederalLaw law;
    private LocalDate date;


    @Override
    public String toString() {
        String stringDate = date.format(DateFormat.STANDART_FORMAT.getDateTimeFormatter());
        return "http://www.zakupki.gov.ru/epz/order/extendedsearch/rss?pageNumber=" + pageNumber + "&" + law.getLaw() + "&publishDateFrom=" + stringDate + "&publishDateTo=" + stringDate;
    }
}