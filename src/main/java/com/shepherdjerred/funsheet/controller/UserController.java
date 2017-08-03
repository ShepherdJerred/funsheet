package com.shepherdjerred.funsheet.controller;

import com.shepherdjerred.funsheet.storage.Store;

import static spark.Spark.get;
import static spark.Spark.post;

public class UserController implements Controller {

    private Store store;

    @Override
    public void setupRoutes() {
        get("/api/login", (request, response) -> {
            response.type("application/json");

            return "Login";
        });

        get("/api/logout", (request, response) -> {
            response.type("application/json");

            return "Logout";
        });

        post("/api/register", (request, response) -> {
            response.type("application/json");

            return "";
        });
    }

}
