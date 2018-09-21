package com.zakupkigovru.dao;

import com.zakupkigovru.model.DbProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbPropertyDao extends CrudRepository<DbProperty, Integer> {
    DbProperty findByKey(String key);

}
