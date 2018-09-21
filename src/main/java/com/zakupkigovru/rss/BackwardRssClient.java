package com.zakupkigovru.rss;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.zakupkigovru.crawler.JsoupClient;
import com.zakupkigovru.dao.DbPropertyDao;
import com.zakupkigovru.date.DateFormat;
import com.zakupkigovru.date.DateUtil;
import com.zakupkigovru.dispatcher.Url;
import com.zakupkigovru.mapper.RawDataMapper;
import com.zakupkigovru.model.DbProperty;
import com.zakupkigovru.model.RawData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.zakupkigovru.dao.DbConstants.LAST_DATE;
import static com.zakupkigovru.dao.DbConstants.LAST_PAGE;

@Component
@Slf4j
public class BackwardRssClient implements RssClient {
    private static final LocalDate LAST_DATE_FOR_PARSING = LocalDate.of(2010, 9, 1);
    private static Integer pageNumber;
    private static LocalDate date;

    private final RawDataMapper rawDataMapper;
    private final DbPropertyDao dbPropertyDao;

    @Autowired
    public BackwardRssClient(RawDataMapper rawDataMapper, DbPropertyDao dbPropertyDao) {
        this.rawDataMapper = rawDataMapper;
        this.dbPropertyDao = dbPropertyDao;
    }

    @PostConstruct
    void init() {
        DbProperty dateProperty = dbPropertyDao.findByKey(LAST_DATE);
        DbProperty pageProperty = dbPropertyDao.findByKey(LAST_PAGE);

        pageNumber = Integer.parseInt(Optional.ofNullable(pageProperty).orElseGet(
                () -> new DbProperty(LAST_PAGE, "0")).getValue());
        date = DateUtil.stringToDate(Optional.ofNullable(dateProperty).orElseGet(
                () -> new DbProperty(LAST_DATE, DateUtil.dateToString(LocalDate.now(), DateFormat.STANDART_FORMAT))).getValue(), DateFormat.STANDART_FORMAT);
    }

    @Override
    @SneakyThrows
    public List<RawData> getNextRawDataList() {
        Url url = Url.builder().pageNumber(pageNumber).date(date).build();
        JsoupClient jsoupClient = new JsoupClient();
        final List<String> linksFromSearchPage = jsoupClient.getLinksFromSearchPage(url);
        final List<SyndEntry> collect = linksFromSearchPage.stream().flatMap((url1) -> getRssEntries(url1).stream()).collect(Collectors.toList());

        return collect.stream().map(rawDataMapper::map).collect(Collectors.toList());
//
//        if (entryList.size() == 0) {
//            decreaseDay();
//            entryList = getRssEntries(url);
//        }
//
//        return entryList.stream().map(rawDataMapper::map).collect(Collectors.toList());
    }

    @SneakyThrows
    private List<SyndEntry> getRssEntries(String url) {
        return new SyndFeedInput().build(new XmlReader(new URL(url))).getEntries();
    }


    private void decreaseDay() {
        pageNumber = 0;
        date = date.minusDays(1);

        checkDateAndUpdateIfNecessary();
    }

    private void checkDateAndUpdateIfNecessary() {
        if (date.isBefore(LAST_DATE_FOR_PARSING)) {
            date = LocalDate.now();
        }
    }

    public void increasePage() {
        pageNumber++;
    }

    public Integer getPage(){
        return pageNumber;
    }

    public LocalDate getDate(){
        return date;
    }

}
