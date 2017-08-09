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
    private Integer rating;
    @Getter
    @Setter
    private UUID location;
    @Getter
    @Setter
    private Integer cost;
    @Getter
    @Setter
    private String description;

    @Override
    public boolean isValid() {
        // Check if name is unique
        // Check types exist
        // Check location exists

        if (rating < 1 || rating > 5) {
            return false;
        }

        if (cost < 0 || cost > 5) {
            return false;
        }

        return true;
    }
}
