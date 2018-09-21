package com.zakupkigovru.crawler;

import com.zakupkigovru.dispatcher.Url;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JsoupClient {


    public static final String SEARCH_PAGE_LINKS = "td.descriptTenderTd > dl > dt > a";

    public static void main(String[] args) {
        final JsoupClient jsoupClient = new JsoupClient();
    }

    @SneakyThrows
    public List<String> getLinksFromSearchPage(Url url){
        Document doc = Jsoup.connect(url.toString()).get();
        Elements links = doc.select(SEARCH_PAGE_LINKS);
        for (Element link : links) {
            final String text = link.getAllElements().text();
            System.out.println(text);
        }
        return null;
    }
}
