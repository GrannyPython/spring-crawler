package com.zakupkigovru.service;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.RunScript;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.sql.SQLException;

@Slf4j
@Component
public class DumpService {

    @Scheduled
    void dumpData() {
        try {
            RunScript.execute("jdbc:h2:./db/data", "sa", "", "./db/backup.sql", Charset.defaultCharset(), true);
        } catch (SQLException e) {
            log.error("Error occues during shutdown");
            e.printStackTrace();
        }
    }
}
