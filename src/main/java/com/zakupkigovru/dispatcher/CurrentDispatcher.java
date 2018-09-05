package com.zakupkigovru.dispatcher;

import org.springframework.stereotype.Component;

@Component
public class CurrentDispatcher implements Dispatcher {
    @Override
    public String nextLink() {
        return null;
    }
}
