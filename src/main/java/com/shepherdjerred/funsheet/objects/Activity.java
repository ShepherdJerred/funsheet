package com.shepherdjerred.funsheet.objects;

import lombok.*;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Activity {

    @Getter
    @Setter
    private String name;
    @Getter
    private final UUID uuid;
    @Getter
    @Setter
    private Type type;
    @Getter
    @Setter
    private int rating;

    public Activity(String name, UUID uuid, Type type, int rating) {
        this.name = name;
        this.uuid = uuid;
        this.type = type;
        this.rating = rating;
    }

}
