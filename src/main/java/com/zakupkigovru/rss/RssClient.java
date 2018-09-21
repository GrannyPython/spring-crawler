package com.zakupkigovru.rss;

import com.zakupkigovru.model.RawData;
import lombok.SneakyThrows;

import java.util.List;

public interface RssClient {

    List<RawData> getNextRawDataList();
}
