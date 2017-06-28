package com.shepherdjerred.funsheet;

import static spark.Spark.*;

public class Main {

    public static void main(String args[]) {
        port(8080);
        get("/", ((request, response) -> "funsheet"));
    }

}

