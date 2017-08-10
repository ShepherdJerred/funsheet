package com.shepherdjerred.funsheet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.payloads.EditActivityPayload;
import com.shepherdjerred.funsheet.payloads.NewActivityPayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class ActivityController implements Controller {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ActivityController(Store store) {
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
            Optional<Activity> activity = store.getActivity(activityUuid);

            if (activity.isPresent()) {
                return objectMapper.writeValueAsString(activity.get());
            } else {
                response.status(404);
                return "Not found";
            }
        });

        post("/api/activities", (request, response) -> {
            response.type("application/json");

            NewActivityPayload activityPayload = objectMapper.readValue(request.body(), NewActivityPayload.class);

            if (!activityPayload.isValid()) {
                response.status(400);
                return "Invalid payload";
            }

            Optional<Type> typeOptional = store.getType(activityPayload.getType());
            Type type = null;
            if (typeOptional.isPresent()) {
                type = typeOptional.get();
            } else {
                // TODO throw exception
            }

            Optional<Location> locationOptional = store.getLocation(activityPayload.getLocation());
            Location location = null;
            if (locationOptional.isPresent()) {
                location = locationOptional.get();
            } else {
                // TODO throw exception
            }

            Activity activity = new Activity(
                    activityPayload.getName(),
                    UUID.randomUUID(),
                    type,
                    activityPayload.getRating(),
                    location,
                    activityPayload.getCost(),
                    activityPayload.getDescription()
            );

            store.addActivity(activity);

            return objectMapper.writeValueAsString(activity);
        });

        patch("/api/activities/:activity", (request, response) -> {
            response.type("application/json");

            EditActivityPayload activityPayload = objectMapper.readValue(request.body(), EditActivityPayload.class);

            if (!activityPayload.isValid()) {
                response.status(400);
                return "Invalid payload";
            }

            Optional<Activity> activityOptional = store.getActivity(activityPayload.getUuid());

            if (activityOptional.isPresent()) {
                Activity activity = activityOptional.get();

                if (activityPayload.getName() != null) {
                    activity.setName(activityPayload.getName());
                }

                if (activityPayload.getType() != null) {
                    Optional<Type> typeOptional = store.getType(activityPayload.getType());
                    if (typeOptional.isPresent()) {
                        activity.setType(typeOptional.get());
                    } else {
                        // TODO throw exception
                    }
                }

                if (activityPayload.getRating() != null) {
                    activity.setRating(activityPayload.getRating());
                }

                if (activityPayload.getLocation() != null) {
                    Optional<Location> locationOptional = store.getLocation(activityPayload.getLocation());
                    if (locationOptional.isPresent()) {
                        activity.setLocation(locationOptional.get());
                    } else {
                        // TODO throw exception
                    }


                }

                if (activityPayload.getCost() != null) {
                    activity.setCost(activityPayload.getCost());
                }

                if (activityPayload.getDescription() != null) {
                    activity.setDescription(activityPayload.getDescription());
                }

                store.updateActivity(activity);

                return objectMapper.writeValueAsString(activity);
            } else {
                // TODO throw exception
                return "";
            }
        });

        delete("/api/activities/:activity", (request, response) -> {
            response.type("application/json");

            String activityParam = request.params().get(":activity");
            UUID activityUuid = UUID.fromString(activityParam);

            store.deleteActivity(activityUuid);

            return "DELETE";
        });
    }

}
