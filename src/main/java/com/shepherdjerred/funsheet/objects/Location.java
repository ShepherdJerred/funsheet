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
    private Coordinate coordinate;

    public Location(String name, UUID uuid, Coordinate coordinate) {
        this.name = name;
        this.uuid = uuid;
        this.coordinate = coordinate;
    }

}
