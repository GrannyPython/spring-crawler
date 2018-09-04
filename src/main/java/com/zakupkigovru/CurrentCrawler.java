package com.zakupkigovru;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrentCrawler implements Crawler {

    @Scheduled(fixedDelay = 10000)
    void checkUpdate(){
        System.out.println("Some work");
    }



}
