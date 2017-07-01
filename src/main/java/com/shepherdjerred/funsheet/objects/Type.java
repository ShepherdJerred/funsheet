package com.shepherdjerred.funsheet.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Type {

    @Getter
    @Setter
    private String name;
    @Getter
    private final UUID uuid;
    @Getter
    @Setter
    private final List<Category> categories;

    public Type(String name, UUID uuid, List<Category> categories) {
        this.name = name;
        this.uuid = uuid;
        this.categories = categories;
    }

}
