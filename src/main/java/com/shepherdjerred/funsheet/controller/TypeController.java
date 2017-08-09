package com.shepherdjerred.funsheet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.payloads.NewTypePayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class TypeController implements Controller {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public TypeController(Store store) {
        this.store = store;
    }

    @Override
    public void setupRoutes() {

        get("/api/types", (request, response) -> {
            response.type("application/json");

            return objectMapper.writeValueAsString(store.getTypes());
        });

        get("/api/types/:type", (request, response) -> {
            response.type("application/json");

            String typeParam = request.params().get(":type");
            UUID typeUuid = UUID.fromString(typeParam);
            Type type = store.getType(typeUuid);

            if (type == null) {
                response.status(404);
                return "Not found";
            } else {
                return objectMapper.writeValueAsString(type);
            }
        });

        post("/api/types", (request, response) -> {
            response.type("application/json");

            NewTypePayload typePayload = objectMapper.readValue(request.body(), NewTypePayload.class);

            if (!typePayload.isValid()) {
                response.status(400);
                return "Invalid payload";
            }

            List<Tag> tags = new ArrayList<>();

            typePayload.getTags().forEach(tagUuid -> tags.add(store.getTag(tagUuid)));

            Type type = new Type(
                    typePayload.getName(),
                    UUID.randomUUID(),
                    tags
            );

            store.addType(type);

            return objectMapper.writeValueAsString(type);
        });

        patch("/api/types/:type", (request, response) -> {
            return ""; // TODO
        });

        delete("/api/types/:type", (request, response) -> {
            response.type("application/json");

            String typeParam = request.params().get(":type");
            UUID typeUuid = UUID.fromString(typeParam);

            store.deleteType(typeUuid);

            return "DELETE";
        });

    }
}
