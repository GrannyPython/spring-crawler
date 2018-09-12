package com.zakupkigovru.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
public class DbProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String key;
    String value;


}


