package com.zakupkigovru.dao;

import com.zakupkigovru.model.RawData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawDataDao extends JpaRepository<RawData, Integer> {
}
