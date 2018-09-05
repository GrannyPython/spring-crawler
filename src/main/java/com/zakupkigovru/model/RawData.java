package com.zakupkigovru.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RawData {
    @Id
    Long id;
    String link;
    String text;
}
