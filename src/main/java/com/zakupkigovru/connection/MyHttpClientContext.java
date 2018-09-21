package com.zakupkigovru.connection;

import com.zakupkigovru.listener.ProxyManager;
import org.apache.http.client.protocol.HttpClientContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

@Component
public class MyHttpClientContext extends HttpClientContext {
    @Autowired
    ProxyManager proxyManager;

    @PostConstruct
    public void init() {
        setAttribute("socks.address", new InetSocketAddress("127.0.0.1", proxyManager.getPort()));
    }
}
