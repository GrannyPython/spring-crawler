package com.zakupkigovru.crawler;

import com.zakupkigovru.dispatcher.Dispatcher;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrentCrawler {

    @Autowired
    Dispatcher currentDispatcher;

    @Autowired
    TorClient client;


    @Scheduled(fixedRate = 60_000L)
    @SneakyThrows
    void checkUpdate() {
        Document doc = Jsoup.connect("http://zakupki.gov.ru/epz/order/quicksearch/search_eis.html?").get();
        System.out.println(doc);
//        final HttpResponse httpResponse = client.sendGetRequest("http://zakupki.gov.ru/223/purchase/public/purchase/info/common-info.html?regNumber=31806711245");
//
//        final String s = EntityUtils.toString(httpResponse.getEntity());
//        System.out.println(s);
        //
//        final Elements select = Jsoup.parse(s).select("#cf-error-details > div.cf-error-footer.cf-wrapper > p > span:nth-child(3)");
//        select.stream().filter(Objects::nonNull).forEach((System.out::println));
    }


}
// http://www.zakupki.gov.ru/epz/order/quicksearch/search_eis.html?morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_50&showLotsInfoHidden=false&fz44=on&fz223=on&ppRf615=on&fz94=on&af=on&ca=on&pc=on&pa=on&currencyId=-1&regionDeleted=false&publishDateFrom=15.09.2018&publishDateTo=15.09.2018&sortBy=UPDATE_DATE
// http://www.zakupki.gov.ru/epz/order/quicksearch/rss?morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_50&showLotsInfoHidden=false&fz44=on&fz223=on&ppRf615=on&fz94=on&af=on&ca=on&pc=on&pa=on&currencyId=-1&regionDeleted=false&publishDateFrom=15.09.2018&publishDateTo=15.09.2018&sortBy=UPDATE_DATE
