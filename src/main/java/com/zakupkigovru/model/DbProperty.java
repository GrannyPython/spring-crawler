package com.zakupkigovru.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class DbProperty {
    @Id
    String key;
    String value;

    public DbProperty(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public DbProperty() {

    }
}


