package com.shepherdjerred.funsheet.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.payloads.NewActivityPayload;
import com.shepherdjerred.funsheet.storage.Store;

import java.util.UUID;

import static spark.Spark.*;

public class ActivityRouter {

    private Store store;

    public ActivityRouter(Store store) {
        this.store = store;
    }

    public void setupRoutes() {
        ObjectMapper objectMapper = new ObjectMapper();

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

            NewActivityPayload activityPayload = objectMapper.readValue(request.body(), NewActivityPayload.class);

            Activity activity = new Activity(
                    activityPayload.getName(),
                    UUID.randomUUID(),
                    store.getType(activityPayload.getTypeUuid()),
                    activityPayload.getRating()
            );

            return objectMapper.writeValueAsString(activity);
        });

        patch("/api/activities/:activity", (request, response) -> {
            return "";
        });
    }

}
