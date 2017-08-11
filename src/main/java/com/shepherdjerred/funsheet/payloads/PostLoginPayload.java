package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

public class PostLoginPayload {

    @Getter
    @Setter
    private final String jsonWebToken;
    @Getter
    @Setter
    private final String username;

    public PostLoginPayload(String jsonWebToken, String username) {
        this.jsonWebToken = jsonWebToken;
        this.username = username;
    }
}
