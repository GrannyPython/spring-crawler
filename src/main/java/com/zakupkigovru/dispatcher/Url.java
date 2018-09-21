package com.zakupkigovru.dispatcher;

import com.zakupkigovru.date.DateFormat;
import com.zakupkigovru.date.DateUtil;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Url {

    private Integer pageNumber;
    private LocalDate date;

    @Override
    public String toString() {
        String stringDate = date.format(DateFormat.STANDART_FORMAT.getDateTimeFormatter());

        final String s = DateUtil.dateToString(date, DateFormat.STANDART_FORMAT);
        String url = String.format("http://www.zakupki.gov.ru/epz/order/quicksearch/search_eis.html?pageNumber=%d&publishDateFrom=%s&publishDateTo=%s&is_far_eastern_district=1&region_regions_5277335=region_regions_5277335&regions=5277335&fz44=on&fz223=on&ppRf615=on&fz94=on", pageNumber, s, s);

//        for (FederalLaw value : FederalLaw.values()) {
//            url.append(value.getLaw());
//        }

        return url.toString();
    }
}