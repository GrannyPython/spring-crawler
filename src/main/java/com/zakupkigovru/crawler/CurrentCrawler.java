package com.zakupkigovru.crawler;

import com.zakupkigovru.dispatcher.Dispatcher;
import com.zakupkigovru.rss.RssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrentCrawler implements Crawler {

    @Autowired
    Dispatcher currentDispatcher;

    @Autowired
    RssClient client;

    @Scheduled(fixedDelay = 10000)
    void checkUpdate() {
        System.out.println("Some work");
    }


    @Override
    public void startCrawling() {

    }
}
