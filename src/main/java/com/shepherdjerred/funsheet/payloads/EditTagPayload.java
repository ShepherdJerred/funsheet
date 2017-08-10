package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class EditTagPayload implements Payload {

    @Getter
    @Setter
    private UUID uuid;
    @Getter
    @Setter
    private String name;

    @Override
    public boolean isValid() {
        return true;
    }
}
