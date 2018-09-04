package com.zakupkigovru;


import lombok.extern.slf4j.Slf4j;
import org.h2.tools.RunScript;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.nio.charset.Charset;
import java.sql.SQLException;

@Slf4j
public class ShutdownListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            RunScript.execute("jdbc:h2:./db/data", "sa", "", "./db/backup.sql", Charset.defaultCharset(), true);
        } catch (SQLException e) {
            log.error("Error occues during shutdown");
            e.printStackTrace();
        }
    }
}