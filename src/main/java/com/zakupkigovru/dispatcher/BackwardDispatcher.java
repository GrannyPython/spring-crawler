package com.zakupkigovru.dispatcher;

import com.zakupkigovru.dao.DbPropertyDao;
import com.zakupkigovru.model.DbProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class BackwardDispatcher implements Dispatcher {
    private static final LocalDate LAST_DATE_FOR_PARSING = LocalDate.of(2010, 9, 1);
    private static Integer page;
    private static LocalDate date;

    @Autowired
    private DbPropertyDao dbPropertyDao;


    @PostConstruct
    void init() {
        DbProperty dateProperty = dbPropertyDao.findByKey("LastDate");
        DbProperty pageProperty = dbPropertyDao.findByKey("LastPage");

//        page = Integer.parseInt(pageProperty.getValue());
//        date = DateUtil.stringToDate(dateProperty.getValue(), DateFormat.STANDART_FORMAT);

    }

    @Override
    public Url getNextLink() {
//        Url.builder().
        return null;
    }
}
