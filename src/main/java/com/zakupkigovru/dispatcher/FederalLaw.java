package com.zakupkigovru.dispatcher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FederalLaw {
    FZ_44("fz44=on"),
    FZ_223("fz223=on"),
    PPRF_615("ppRf615=on"),
    FZ_94("fz94=on");

    final String law;

}
