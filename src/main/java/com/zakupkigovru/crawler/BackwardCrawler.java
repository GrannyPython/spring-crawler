package com.zakupkigovru.crawler;

import com.zakupkigovru.dao.RawDataDao;
import com.zakupkigovru.dispatcher.Dispatcher;
import com.zakupkigovru.dispatcher.Url;
import com.zakupkigovru.model.RawData;
import com.zakupkigovru.rss.RssClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class BackwardCrawler implements Crawler {
    private final Dispatcher backwardDispatcher;
    private final RssClient client;
    private final RawDataDao rawDataDao;

    @Autowired
    public BackwardCrawler(Dispatcher backwardDispatcher, RssClient client, RawDataDao rawDataDao) {
        this.backwardDispatcher = backwardDispatcher;
        this.client = client;
        this.rawDataDao = rawDataDao;
    }

    @Scheduled(fixedDelay = 10_000L)
    public void startCrawling() {
        log.info("BackwardCrawler started");
        Url url = backwardDispatcher.getNextLink();
        List<RawData> rawDataList = client.findRawDataListByUrl(url);
//
//        log.info("BC Url is " + url.toString());
        for (RawData rawData : rawDataList) {
            rawDataDao.save(rawData);
        }

        log.info(rawDataList.size() + " rawDataEntries were added to db");

    }


}
