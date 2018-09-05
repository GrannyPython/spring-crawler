package com.zakupkigovru.service;

import com.zakupkigovru.dao.RawDataDao;
import com.zakupkigovru.model.RawData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawdataService {
    @Autowired
    RawDataDao rawDataDao;

    void saveAll(List<RawData> list) {
        List<RawData> rawData = rawDataDao.saveAll(list);
    }
}
