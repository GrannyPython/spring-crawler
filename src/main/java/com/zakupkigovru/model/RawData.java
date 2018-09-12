package com.zakupkigovru.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class RawData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String link;

    @Column(length=5000)
    String text;
}
