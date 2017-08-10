package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class EditTypePayload implements Payload {

    @Getter
    @Setter
    private UUID uuid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<UUID> tags;

    @Override
    public boolean isValid() {
        // Verify tags
        // Verify name
        return true;
    }
}
