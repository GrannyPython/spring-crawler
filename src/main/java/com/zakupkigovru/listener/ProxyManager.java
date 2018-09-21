package com.zakupkigovru.listener;

import com.msopentech.thali.java.toronionproxy.JavaOnionProxyContext;
import com.msopentech.thali.java.toronionproxy.JavaOnionProxyManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProxyManager {
    private static final int TOTAL_SECONDS_PER_TOR_STARTUP = 4 * 60;
    private static final int TOTAL_TRIES_PER_TOR_STARTUP = 5;

    private JavaOnionProxyManager onionProxyManager;

    @SneakyThrows
    @PostConstruct
    public void init() {
        this.onionProxyManager = new JavaOnionProxyManager(
                new JavaOnionProxyContext(
                        Files.createTempDirectory("torfile").toFile()));

        try {
            boolean ok = onionProxyManager.startWithRepeat(TOTAL_SECONDS_PER_TOR_STARTUP, TOTAL_TRIES_PER_TOR_STARTUP);

            if (!ok)
                log.info("TorTest", "Couldn't start Tor!");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public int getPort() {
        return onionProxyManager.getIPv4LocalHostSocksPort();
    }

}