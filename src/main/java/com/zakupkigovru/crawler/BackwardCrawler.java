package com.zakupkigovru.crawler;

import com.zakupkigovru.dispatcher.Dispatcher;
import com.zakupkigovru.rss.RssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BackwardCrawler implements Crawler {
    @Autowired
    Dispatcher backwardDispatcher;

    @Autowired
    RssClient client;

    @EventListener(ContextRefreshedEvent.class)
    public void startCrawling() {
        System.out.println("BackwardCrawler started");
    }


}
