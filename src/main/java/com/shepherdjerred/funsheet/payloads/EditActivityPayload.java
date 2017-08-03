package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class EditActivityPayload implements Payload {

    @Getter
    @Setter
    private UUID uuid;
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
    private Double cost;
    @Getter
    @Setter
    private String description;

    @Override
    public boolean isValid() {
        // Check activity exists
        // Check if name is unique
        // Check types exist
        // Check location exists

        if (rating != null) {
            if (rating < 1 || rating > 5) {
                return false;
            }
        }

        if (cost != null) {
            if (cost < 0 || cost > 5) {
                return false;
            }
        }

        return true;
    }

}
