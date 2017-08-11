package com.shepherdjerred.funsheet.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.objects.User;
import com.shepherdjerred.funsheet.payloads.EditTypePayload;
import com.shepherdjerred.funsheet.payloads.NewTypePayload;
import com.shepherdjerred.funsheet.storage.Store;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
            Optional<Type> type = store.getType(typeUuid);

            if (type.isPresent()) {
                return objectMapper.writeValueAsString(type.get());
            } else {
                response.status(404);
                return "";
            }
        });

        post("/api/types", (request, response) -> {
            response.type("application/json");

            NewTypePayload typePayload = objectMapper.readValue(request.body(), NewTypePayload.class);

            ProcessBuilder processBuilder = new ProcessBuilder();
            Algorithm algorithm = Algorithm.HMAC256(processBuilder.environment().get("JWT_SECRET"));
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("http://funsheet.herokuapp.com")
                    .build();
            DecodedJWT jwt = verifier.verify(typePayload.getJwt());

            UUID userUuid = store.getUserUuid(jwt.getClaim("username").asString());
            Optional<User> userToAuthTo = store.getUser(userUuid);

            if (!userToAuthTo.isPresent()) {
                response.status(401);
                return "";
            }

            if (!userToAuthTo.get().authenticate(jwt.getClaim("password").asString())) {
                response.status(401);
                return "";
            }

            if (!typePayload.isValid()) {
                response.status(400);
                return "";
            }

            if (store.isTypeNameTaken(typePayload.getName())) {
                response.status(400);
                return "";
            }

            List<Tag> tags = new ArrayList<>();

            for (UUID tag : typePayload.getTags()) {
                Optional<Tag> tagOptional = store.getTag(tag);
                if (tagOptional.isPresent()) {
                    tags.add(tagOptional.get());
                } else {
                    response.status(400);
                    return "";
                }
            }

            Type type = new Type(
                    typePayload.getName(),
                    UUID.randomUUID(),
                    tags
            );

            store.addType(type);

            return objectMapper.writeValueAsString(type);
        });

        patch("/api/types/:type", (request, response) -> {
            response.type("application/json");

            EditTypePayload typePayload = objectMapper.readValue(request.body(), EditTypePayload.class);

            ProcessBuilder processBuilder = new ProcessBuilder();
            Algorithm algorithm = Algorithm.HMAC256(processBuilder.environment().get("JWT_SECRET"));
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("http://funsheet.herokuapp.com")
                    .build();
            DecodedJWT jwt = verifier.verify(typePayload.getJwt());

            UUID userUuid = store.getUserUuid(jwt.getClaim("username").asString());
            Optional<User> userToAuthTo = store.getUser(userUuid);

            if (!userToAuthTo.isPresent()) {
                response.status(401);
                return "";
            }

            if (!userToAuthTo.get().authenticate(jwt.getClaim("password").asString())) {
                response.status(401);
                return "";
            }

            if (!typePayload.isValid()) {
                response.status(400);
                return "";
            }

            Optional<Type> typeOptional = store.getType(typePayload.getUuid());

            if (typeOptional.isPresent()) {
                Type type = typeOptional.get();

                if (typePayload.getName() != null) {
                    if (store.isTypeNameTaken(typePayload.getName())&& !type.getName().equals(typePayload.getName())) {
                        response.status(400);
                        return "";
                    }
                    type.setName(typePayload.getName());
                }

                if (typePayload.getTags() != null) {
                    List<Tag> tags = new ArrayList<>();
                    for (UUID tag : typePayload.getTags()) {
                        Optional<Tag> tagOptional = store.getTag(tag);
                        if (tagOptional.isPresent()) {
                            tags.add(tagOptional.get());
                        } else {
                            response.status(400);
                            return "";
                        }
                    }
                    type.setTags(tags);
                }

                store.updateType(type);

                return objectMapper.writeValueAsString(type);
            } else {
                response.status(400);
                return "";
            }
        });

        delete("/api/types/:type", (request, response) -> {
            response.type("application/json");

            // TODO auth

            String typeParam = request.params().get(":type");
            UUID typeUuid = UUID.fromString(typeParam);

            store.deleteType(typeUuid);

            return "";
        });

    }
}
