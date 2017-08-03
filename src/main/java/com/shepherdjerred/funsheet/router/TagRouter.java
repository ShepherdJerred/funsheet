package com.shepherdjerred.funsheet.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.payloads.NewTagPayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import static spark.Spark.*;

@Log4j2
public class TagRouter implements Router {

    private Store store;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public TagRouter(Store store) {
        this.store = store;
    }

    @Override
    public void setupRoutes() {
        get("/api/tags", (request, response) -> {
            response.type("application/json");

            return objectMapper.writeValueAsString(store.getTags());
        });

        get("/api/tags/:tag", (request, response) -> {
            response.type("application/json");

            String tagParam = request.params().get(":tag");
            UUID tagUuid = UUID.fromString(tagParam);
            Tag tag = store.getTag(tagUuid);

            if (tag == null) {
                response.status(404);
                return "Not found";
            } else {
                return objectMapper.writeValueAsString(tag);
            }
        });

        post("/api/tags", (request, response) -> {
            response.type("application/json");

            NewTagPayload tagPayload = objectMapper.readValue(request.body(), NewTagPayload.class);

            if (!tagPayload.isValid()) {
                response.status(400);
                return "Invalid payload";
            }

            Tag tag = new Tag(
                    tagPayload.getName(),
                    UUID.randomUUID()
            );

            store.addTag(tag);

            return objectMapper.writeValueAsString(tag);
        });

        patch("/api/tags/:tag", (request, response) -> {
            return "";
        });
    }
}
