package com.zakupkigovru.crawler;

import com.zakupkigovru.connection.MyConnectionSocketFactory;
import com.zakupkigovru.connection.MyHttpClientContext;
import com.zakupkigovru.connection.MySSLConnectionSocketFactory;
import com.zakupkigovru.listener.ProxyManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class TorClient {
    @Autowired
    ProxyManager proxyManager;
    @Autowired
    private MyHttpClientContext httpClientContext;

    private HttpClient httpClient;

    @PostConstruct
    public void init() {
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", new MySSLConnectionSocketFactory())
                .register("http", new MyConnectionSocketFactory())
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(reg);
        this.httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }

    @SneakyThrows
    public HttpResponse sendGetRequest(String url) {
        HttpGet request = new HttpGet(url);

        //TODO: HeadersRotation
//        request.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
//        request.setHeader(HttpHeaders.ACCEPT_LANGUAGE, "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
//        request.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        return httpClient.execute(request, httpClientContext);
    }
}


