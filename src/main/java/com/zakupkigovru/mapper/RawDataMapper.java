package com.zakupkigovru.mapper;

import com.rometools.rome.feed.synd.SyndEntry;
import com.zakupkigovru.model.RawData;
import org.springframework.stereotype.Component;

@Component
public class RawDataMapper {
    public RawData map(SyndEntry entry) {
        return RawData.builder().link(entry.getLink()).text(entry.getDescription().getValue()).build();
    }
}
