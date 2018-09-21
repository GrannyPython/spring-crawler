package com.zakupkigovru.dispatcher;

public enum FederalDistrict {
    FAR_EAST("&is_far_eastern_district=1&districts=5277399");

    FederalDistrict(String value) {
        this.value = value;
    }

    String value;
}
