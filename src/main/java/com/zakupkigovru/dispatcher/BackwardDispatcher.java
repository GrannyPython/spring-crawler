package com.zakupkigovru.dispatcher;

import com.zakupkigovru.dao.DbPropertyDao;
import com.zakupkigovru.date.DateFormat;
import com.zakupkigovru.date.DateUtil;
import com.zakupkigovru.model.DbProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class BackwardDispatcher implements Dispatcher {
    private static final LocalDate LAST_DATE_FOR_PARSING = LocalDate.of(2010, 9, 1);

    @Autowired
    private DbPropertyDao dbPropertyDao;

    private Integer page;
    private LocalDate date;

    @PostConstruct
    void init() {
        DbProperty dateProperty = dbPropertyDao.findByKey("LastDate");
        DbProperty pageProperty = dbPropertyDao.findByKey("LastPage");

        page = Integer.parseInt(pageProperty.getValue());
        date = DateUtil.stringToDate(dateProperty.getValue(), DateFormat.STANDART_FORMAT);
    }

    @Override
    public String nextLink() {
        Url.builder().
        return null;
    }
}
