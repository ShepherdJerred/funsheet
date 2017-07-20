package com.shepherdjerred.funsheet.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.payloads.NewLocationPayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class LocationRouter implements Router {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public LocationRouter(Store store) {
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
            Location location = store.getLocation(locationUuid);

            if (location == null) {
                response.status(404);
                return "Not found";
            } else {
                return objectMapper.writeValueAsString(location);
            }
        });

        post("/api/locations", (request, response) -> {
            response.type("application/json");

            log.info(request.body());

            NewLocationPayload locationPayload = objectMapper.readValue(request.body(), NewLocationPayload.class);

            Location location = new Location(
                    locationPayload.getName(),
                    UUID.randomUUID(),
                    locationPayload.getPlaceId()
            );

            store.addLocation(location);

            return objectMapper.writeValueAsString(location);
        });

        patch("/api/locations/:location", (request, response) -> {
            return "";
        });
    }
}
