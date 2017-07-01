package com.shepherdjerred.funsheet.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Category {

    @Getter
    @Setter
    private String name;
    @Getter
    private final UUID uuid;

    public Category(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }
}
