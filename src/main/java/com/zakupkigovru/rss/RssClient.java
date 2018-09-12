package com.zakupkigovru.rss;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.zakupkigovru.dao.RawDataDao;
import com.zakupkigovru.dispatcher.Url;
import com.zakupkigovru.mapper.RawDataMapper;
import com.zakupkigovru.model.RawData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RssClient {

    @Autowired
    RawDataMapper rawDataMapper;

    @Autowired
    RawDataDao rawDataDao;

    public static void main(String[] args) {
        RssClient rssClient = new RssClient();
        rssClient.findRawDataListByUrl(null);
    }

    @SneakyThrows
    public List<RawData> findRawDataListByUrl(Url url) {
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new FileInputStream(new File("C:\\Users\\GP\\IdeaProjects\\spring-crawler\\src\\main\\resources\\1.xml"))));
        List<SyndEntry> entries = feed.getEntries();

        return entries.stream().map(rawDataMapper::map).collect(Collectors.toList());
    }
}
