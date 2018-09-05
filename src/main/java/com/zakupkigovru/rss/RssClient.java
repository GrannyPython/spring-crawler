package com.zakupkigovru.rss;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.zakupkigovru.dispatcher.Url;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class RssClient {

    @SneakyThrows
    public List<SyndEntry> findRssEntriesListByUrl(Url url) {
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new FileInputStream(new File("C:\\Users\\JavaStudent\\IdeaProjects\\spring-crawler\\src\\main\\resources\\1.xml"))));

        return new ArrayList<>(feed.getEntries());
    }
}
