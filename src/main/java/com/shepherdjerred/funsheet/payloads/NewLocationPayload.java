package com.shepherdjerred.funsheet.payloads;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class NewLocationPayload implements Payload {

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
