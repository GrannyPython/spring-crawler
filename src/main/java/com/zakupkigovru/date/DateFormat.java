package com.zakupkigovru.date;

import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public enum DateFormat {
    STANDART_FORMAT(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    private DateTimeFormatter dateTimeFormatter;

    DateFormat(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

}
