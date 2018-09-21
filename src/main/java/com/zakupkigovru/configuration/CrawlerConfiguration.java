package com.zakupkigovru.configuration;

import com.zakupkigovru.connection.MyHttpClientContext;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CrawlerConfiguration {
    @Autowired
    MyHttpClientContext clientContext;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    HtmlUnitDriver htmlUnitDriver() {
        return new HtmlUnitDriver();
    }


}
