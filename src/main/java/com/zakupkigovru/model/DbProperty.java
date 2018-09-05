package com.zakupkigovru.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
public class DbProperty {
    String key;
    String value;


}
