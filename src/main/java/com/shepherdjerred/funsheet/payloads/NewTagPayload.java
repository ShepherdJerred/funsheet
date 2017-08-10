package com.shepherdjerred.funsheet.payloads;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class NewTagPayload implements Payload {

    @Getter
    @Setter
    private String name;

    @Override
    public boolean isValid() {
        return true;
    }
}
