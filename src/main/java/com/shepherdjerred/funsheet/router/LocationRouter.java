package com.shepherdjerred.funsheet.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LocationRouter implements Router {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public LocationRouter(Store store) {
        this.store = store;
    }

    @Override
    public void setupRoutes() {

    }
}
