package com.shepherdjerred.funsheet.payloads;

import lombok.Getter;
import lombok.Setter;

public class RegisterPayload implements Payload {

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;


    @Override
    public boolean isValid() {
        if (password.length() < 8) {
            return false;
        }
        if (password.equals(username)) {
            return false;
        }
        return true;
    }
}
