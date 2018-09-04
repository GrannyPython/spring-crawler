package com.zakupkigovru;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        String s = Url.builder().pageNumber(1).law(FederalLaw.FZ_44).date(LocalDate.now()).build().toString();
        System.out.println(s);
    }
}
