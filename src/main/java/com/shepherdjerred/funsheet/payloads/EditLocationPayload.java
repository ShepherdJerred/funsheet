package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class EditLocationPayload implements Payload {

    @Getter
    @Setter
    private UUID uuid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String placeId;
    @Getter
    @Setter
    private String jwt;

    @Override
    public boolean isValid() {
        return true;
    }
}
