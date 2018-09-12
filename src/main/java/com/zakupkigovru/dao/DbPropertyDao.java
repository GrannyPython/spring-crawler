package com.zakupkigovru.dao;

import com.zakupkigovru.model.DbProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbPropertyDao extends JpaRepository<DbProperty, Integer> {
    DbProperty findByKey(String key);

}
