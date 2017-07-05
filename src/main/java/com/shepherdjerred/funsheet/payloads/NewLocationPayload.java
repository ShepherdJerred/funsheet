package com.shepherdjerred.funsheet.payloads;

import com.shepherdjerred.funsheet.objects.Location;
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
    private Location parentLocation;
    @Getter
    @Setter
    private String website;

    @Override
    public boolean isValid() {
        return false;
    }
}
