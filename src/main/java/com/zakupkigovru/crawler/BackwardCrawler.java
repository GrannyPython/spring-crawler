package com.zakupkigovru.crawler;

import com.zakupkigovru.dao.DbConstants;
import com.zakupkigovru.dao.DbPropertyDao;
import com.zakupkigovru.dao.RawDataDao;
import com.zakupkigovru.date.DateFormat;
import com.zakupkigovru.date.DateUtil;
import com.zakupkigovru.model.DbProperty;
import com.zakupkigovru.model.RawData;
import com.zakupkigovru.rss.BackwardRssClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class BackwardCrawler {
    private final RawDataDao rawDataDao;
    private final BackwardRssClient client;
    private final DbPropertyDao propertyDao;
    private final JsoupClient jClient;

    @Autowired
    public BackwardCrawler(RawDataDao rawDataDao, BackwardRssClient client, DbPropertyDao propertyDao, JsoupClient jClient) {
        this.client = client;
        this.rawDataDao = rawDataDao;
        this.propertyDao = propertyDao;
        this.jClient = jClient;
    }
    @Scheduled(fixedDelay = 1000_000L)
    public void startCrawling() {
        log.trace("BackwardCrawler started");

        List<RawData> rawDataList = client.getNextRawDataList();
        rawDataDao.saveAll(rawDataList);
        log.info(rawDataList.size() + " rawDataEntries were added to db");

        String date = DateUtil.dateToString(client.getDate(), DateFormat.STANDART_FORMAT);
        String page = client.getPage().toString();

        propertyDao.save(new DbProperty(DbConstants.LAST_DATE, date));
        propertyDao.save(new DbProperty(DbConstants.LAST_PAGE, page));
        log.info("Parsing date is {}, page is {} were saved", date, page);

        client.increasePage();

        log.trace("BackwardCrawler finished");
    }
}
