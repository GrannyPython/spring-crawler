package com.zakupkigovru.dispatcher;

import org.springframework.stereotype.Component;

@Component
public class CurrentDispatcher implements Dispatcher {
    @Override
    public Url getNextLink() {
        return null;
    }
}
