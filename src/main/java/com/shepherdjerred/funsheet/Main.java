package com.shepherdjerred.funsheet;

import com.shepherdjerred.funsheet.router.ActivityRouter;
import com.shepherdjerred.funsheet.storage.Store;
import com.shepherdjerred.funsheet.storage.mysql.Database;
import com.shepherdjerred.funsheet.storage.mysql.MysqlStore;
import com.zaxxer.hikari.HikariConfig;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Main {

    private static Store store;

    public static void main(String args[]) {
        setupStorage();
        setupRoutes();
    }

    private static void setupStorage() {
//        store = new MockStore();
        HikariConfig hikariConfig = new HikariConfig("hikari.properties");

        Database database = new Database(hikariConfig);
        database.migrate();

        store = new MysqlStore(database);
    }

    private static void setupRoutes() {

        port(8080);
        staticFileLocation("/");

        new ActivityRouter(store).setupRoutes();

    }

}
