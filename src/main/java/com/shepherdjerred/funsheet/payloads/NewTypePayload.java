package com.shepherdjerred.funsheet.payloads;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@ToString
@EqualsAndHashCode
public class NewTypePayload implements Payload {

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
