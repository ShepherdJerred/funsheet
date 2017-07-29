package com.shepherdjerred.funsheet;

import com.shepherdjerred.funsheet.objects.*;
import com.shepherdjerred.funsheet.router.ActivityRouter;
import com.shepherdjerred.funsheet.router.LocationRouter;
import com.shepherdjerred.funsheet.router.TagRouter;
import com.shepherdjerred.funsheet.router.TypeRouter;
import com.shepherdjerred.funsheet.storage.InMemoryStore;
import com.shepherdjerred.funsheet.storage.Store;
import com.shepherdjerred.funsheet.storage.mysql.Database;
import com.shepherdjerred.funsheet.storage.mysql.MysqlStore;
import com.zaxxer.hikari.HikariConfig;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.http.client.indirect.FormClient;
import org.pac4j.http.credentials.authenticator.test.SimpleTestUsernamePasswordAuthenticator;
import org.pac4j.sparkjava.CallbackRoute;
import org.pac4j.sparkjava.DefaultHttpActionAdapter;
import org.pac4j.sparkjava.SecurityFilter;
import org.pac4j.sparkjava.SparkWebContext;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static spark.Spark.*;

public class Main {

    private static Store store;

    public static void main(String args[]) {
        setupMysqlStorage();
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

        FormClient formClient = new FormClient();
        formClient.setAuthenticator(new SimpleTestUsernamePasswordAuthenticator());
        formClient.setLoginUrl("/login");

        Config config = new Config();
        config.setClients(new Clients("/login/callback", formClient));
        config.setHttpActionAdapter(new DefaultHttpActionAdapter());

        before("/login", new SecurityFilter(config, "FormClient"));

        CallbackRoute callback = new CallbackRoute(config, "/login/callback", true);
        get("/login/callback", callback);
        post("/login/callback", callback);

        new ActivityRouter(store).setupRoutes();
        new TypeRouter(store).setupRoutes();
        new TagRouter(store).setupRoutes();
        new LocationRouter(store).setupRoutes();

        get("/test", ((request, response) -> {
            WebContext context = new SparkWebContext(request, response);
            ProfileManager manager = new ProfileManager(context);
            Optional<CommonProfile> profile = manager.get(true);
            return profile.<Object>map(UserProfile::toString).orElse("no profile");
        }));

//        before("/api/*", new SecurityFilter(config, "FormClient"));
//        get("/logout", new LogoutRoute(config, "/?defaulturlafterlogout"));

    }

    private static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }

}
