package com.shepherdjerred.funsheet;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.router.ActivityRouter;
import com.shepherdjerred.funsheet.router.LocationRouter;
import com.shepherdjerred.funsheet.router.TagRouter;
import com.shepherdjerred.funsheet.router.TypeRouter;
import com.shepherdjerred.funsheet.storage.InMemoryStore;
import com.shepherdjerred.funsheet.storage.Store;
import com.shepherdjerred.funsheet.storage.mysql.Database;
import com.shepherdjerred.funsheet.storage.mysql.MysqlStore;
import com.zaxxer.hikari.HikariConfig;

import java.util.Collections;
import java.util.UUID;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Main {

    private static Store store;

    public static void main(String args[]) {
        setupInMemoryStorage();
        createMockData();
        setupRoutes();
    }

    private static void createMockData() {
        Tag entertainment = new Tag("Entertainment", UUID.randomUUID());
        Tag food = new Tag("Food", UUID.randomUUID());
        Tag outdoors = new Tag("Outdoors", UUID.randomUUID());

        Location littleRock = new Location("Little Rock", UUID.randomUUID(), "ChIJm1YfoTSh0ocRF1vzDRD1BTQ");
        Location searcy = new Location("Searcy", UUID.randomUUID(), "ChIJRdqBTnCp04cR9YqY9ZaPmdo");
        Location baldKnob = new Location("Bald Knob", UUID.randomUUID(), "ChIJR47VhpCY04cRdHg7FXFimY8");

        Type movieTheater = new Type("Movie Theater", UUID.randomUUID(), Collections.singletonList(entertainment));
        Type restaurant = new Type("Restaurant", UUID.randomUUID(), Collections.singletonList(food));
        Type hiking = new Type("Hiking", UUID.randomUUID(), Collections.singletonList(outdoors));

        Activity littleRockRiverTrail = new Activity(
                "Arkansas River Trail",
                UUID.randomUUID(),
                hiking,
                3,
                littleRock,
                1,
                "The Arkansas River Trail is a rail trail that runs 17 miles in along both sides of the Arkansas River in Central Arkansas.");
        Activity searcyMovieTheatre = new Activity(
                "Searcy Cinema 8",
                UUID.randomUUID(),
                movieTheater,
                2,
                searcy,
                2,
                "Searcy Cinema 8 - movie theatre serving Searcy, Arkansas and the surrounding area. Great family entertainment at your local movie theater.");
        Activity bulldogCafe = new Activity(
                "Bulldog Restaurant",
                UUID.randomUUID(),
                restaurant,
                3,
                baldKnob,
                1,
                "Great strawberry shortcake!");

        store.addTag(entertainment);
        store.addTag(food);
        store.addTag(outdoors);

        store.addLocation(littleRock);
        store.addLocation(searcy);
        store.addLocation(baldKnob);

        store.addType(movieTheater);
        store.addType(restaurant);
        store.addType(hiking);

        store.addActivity(littleRockRiverTrail);
        store.addActivity(searcyMovieTheatre);
        store.addActivity(bulldogCafe);
    }

    private static void setupInMemoryStorage() {
        store = new InMemoryStore();
    }

    private static void setupMysqlStorage() {
        HikariConfig hikariConfig = new HikariConfig("hikari.properties");

        Database database = new Database(hikariConfig);
        database.migrate();

        store = new MysqlStore(database);
    }

    private static void setupRoutes() {

        int port = getPort();
        port(port);
        staticFileLocation("/funsheet-vue/dist");

        new ActivityRouter(store).setupRoutes();
        new TypeRouter(store).setupRoutes();
        new TagRouter(store).setupRoutes();
        new LocationRouter(store).setupRoutes();
    }

    private static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }

}
