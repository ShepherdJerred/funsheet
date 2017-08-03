package com.shepherdjerred.funsheet.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class User {

    @Getter
    private final UUID uuid;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

}
