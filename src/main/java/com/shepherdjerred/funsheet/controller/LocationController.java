package com.shepherdjerred.funsheet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.payloads.EditLocationPayload;
import com.shepherdjerred.funsheet.payloads.NewLocationPayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class LocationController implements Controller {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(Store store) {
        this.store = store;
    }

    @Override
    public void setupRoutes() {

        get("/api/locations", (request, response) -> {
            response.type("application/json");

            return objectMapper.writeValueAsString(store.getLocations());
        });

        get("/api/locations/:location", (request, response) -> {
            response.type("application/json");

            String locationParam = request.params().get(":location");
            UUID locationUuid = UUID.fromString(locationParam);
            Optional<Location> location = store.getLocation(locationUuid);

            if (location.isPresent()) {
                return objectMapper.writeValueAsString(location.get());
            } else {
                response.status(404);
                return null;
            }
        });

        post("/api/locations", (request, response) -> {
            response.type("application/json");

            log.info(request.body());

            NewLocationPayload locationPayload = objectMapper.readValue(request.body(), NewLocationPayload.class);

            if (!locationPayload.isValid()) {
                response.status(400);
                return null;
            }

            if (store.isLocationNameTaken(locationPayload.getName())) {
                response.status(400);
                return null;
            }

            Location location = new Location(
                    locationPayload.getName(),
                    UUID.randomUUID(),
                    locationPayload.getPlaceId()
            );

            store.addLocation(location);

            return objectMapper.writeValueAsString(location);
        });

        patch("/api/locations/:location", (request, response) -> {
            response.type("application/json");

            EditLocationPayload locationPayload = objectMapper.readValue(request.body(), EditLocationPayload.class);

            if (!locationPayload.isValid()) {
                response.status(400);
                return null;
            }

            Optional<Location> locationOptional = store.getLocation(locationPayload.getUuid());

            if (locationOptional.isPresent()) {
                Location location = locationOptional.get();

                if (locationPayload.getName() != null) {
                    if (store.isLocationNameTaken(locationPayload.getName())&& !location.getName().equals(locationPayload.getName())) {
                        response.status(400);
                        return null;
                    }
                    location.setName(locationPayload.getName());
                }

                if (locationPayload.getPlaceId() != null) {
                    location.setPlaceId(locationPayload.getPlaceId());
                }

                store.updateLocation(location);

                return objectMapper.writeValueAsString(location);
            } else {
                response.status(400);
                return null;
            }
        });

        delete("/api/locations/:location", (request, response) -> {
            response.type("application/json");

            String locationParam = request.params().get(":location");
            UUID locationUuid = UUID.fromString(locationParam);

            store.deleteLocation(locationUuid);

            return null;
        });
    }
}
