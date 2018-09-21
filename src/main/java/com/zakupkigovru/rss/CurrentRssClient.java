//package com.zakupkigovru.rss;
//
//import com.rometools.rome.feed.synd.SyndEntry;
//import com.rometools.rome.feed.synd.SyndFeed;
//import com.rometools.rome.io.SyndFeedInput;
//import com.rometools.rome.io.XmlReader;
//import com.zakupkigovru.dao.RawDataDao;
//import com.zakupkigovru.dispatcher.BackwardDispatcher;
//import com.zakupkigovru.dispatcher.Dispatcher;
//import com.zakupkigovru.dispatcher.Url;
//import com.zakupkigovru.mapper.RawDataMapper;
//import com.zakupkigovru.model.DbProperty;
//import com.zakupkigovru.model.RawData;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class CurrentRssClient {
//
//    @Autowired
//    RawDataMapper rawDataMapper;
//
//    @Autowired
//    RawDataDao rawDataDao;
//
//    @Autowired
//    Dispatcher dispatcher;
//
//    @SneakyThrows
//    public List<RawData> getNextRawDataList() {
//
////        final DbProperty dbProperty = DbProperty.builder().key("LastPage").value("0").build();
////        final DbProperty dbProperty1 = DbProperty.builder().key("LastDate").value("2018-09-12").build();
////
////        final DbProperty save = dao.save(dbProperty);
////        final DbProperty dbProperty2 = dao.save(dbProperty1);
////
////        System.out.println(save);
////        System.out.println(dbProperty2);
//
//        //create url
//        //check url
//        //if 200 return result
//        //if 0 change url and try again
//        //else return result;
//
//        final Url nextLink = dispatcher.getNextLink();
//
//        SyndFeed feed = new SyndFeedInput().build(new XmlReader(url));//        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new FileInputStream(new File("C:\\Users\\GP\\IdeaProjects\\spring-crawler\\src\\main\\resources\\1.xml"))));
//        List<SyndEntry> entries = feed.getEntries();
//
//        return entries.stream().map(rawDataMapper::map).collect(Collectors.toList());
//    }
//}
