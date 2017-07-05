package com.shepherdjerred.funsheet.payloads;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class NewActivityPayload implements Payload {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private UUID type;
    @Getter
    @Setter
    private int rating;
    @Getter
    @Setter
    private UUID location;

    @Override
    public boolean isValid() {
        return true;
    }
}
