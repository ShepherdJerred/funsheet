package com.shepherdjerred.funsheet.objects;

import lombok.*;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Location {

    @Getter
    @Setter
    private String name;
    @Getter
    private final UUID uuid;
    @Getter
    @Setter
    private Location parentLocation;
    @Getter
    @Setter
    private String website;

    public Location(String name, UUID uuid, Location parentLocation, String website) {
        this.name = name;
        this.uuid = uuid;
        this.parentLocation = parentLocation;
        this.website = website;
    }

}
