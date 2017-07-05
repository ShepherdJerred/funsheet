package com.shepherdjerred.funsheet.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.payloads.NewActivityPayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class ActivityRouter implements Router {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ActivityRouter(Store store) {
        this.store = store;
    }

    public void setupRoutes() {

        get("/api/activities", (request, response) -> {
            response.type("application/json");

            return objectMapper.writeValueAsString(store.getActivities());
        });

        get("/api/activities/:activity", (request, response) -> {
            response.type("application/json");

            String activityParam = request.params().get(":activity");
            UUID activityUuid = UUID.fromString(activityParam);
            Activity activity = store.getActivity(activityUuid);

            if (activity == null) {
                response.status(404);
                return "Not found";
            } else {
                return objectMapper.writeValueAsString(activity);
            }
        });

        post("/api/activities", (request, response) -> {
            response.type("application/json");

            log.info(request.body());

            NewActivityPayload activityPayload = objectMapper.readValue(request.body(), NewActivityPayload.class);

            Activity activity = new Activity(
                    activityPayload.getName(),
                    UUID.randomUUID(),
                    store.getType(activityPayload.getType()),
                    activityPayload.getRating(),
                    store.getLocation(activityPayload.getLocation())
            );

            store.addActivity(activity);

            return objectMapper.writeValueAsString(activity);
        });

        patch("/api/activities/:activity", (request, response) -> {
            return "";
        });
    }

}
