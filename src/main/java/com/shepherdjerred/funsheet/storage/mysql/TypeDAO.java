package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.storage.Store;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Mapper;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class TypeDAO implements DAO<Type> {

    private final Store store;
    private final FluentJdbc fluentJdbc;
    private static Mapper<Type> typeMapper;


    public TypeDAO(Database database, Store store) {
        fluentJdbc = new FluentJdbcBuilder().connectionProvider(database.getDataSource()).build();
        this.store = store;
        // TODO don't create with every object (should be static?)
        // TODO map/load tags
        typeMapper = rs -> new Type(
                rs.getString("name"),
                UUID.fromString(rs.getString("type_uuid")),
                new ArrayList<>());
    }

    @Override
    public Optional<Type> select(UUID uuid) {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM type WHERE type_uuid = ?")
                .params(String.valueOf(uuid))
                .firstResult(typeMapper);
    }

    @Override
    public Collection<Type> select() {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM type")
                .listResult(typeMapper);
    }

    @Override
    public void insert(Type type) {
        Query query = fluentJdbc.query();
        query.update("INSERT INTO type VALUES (?, ?)")
                .params(String.valueOf(type.getUuid()),
                        type.getName())
                .run();

        type.getTags().forEach(tag -> {
            query.update("INSERT INTO type_tags VALUES (?, ?)")
                    .params(String.valueOf(type.getUuid()),
                            tag.getUuid())
                    .run();
        });
    }

    @Override
    public void drop(Type type) {
        Query query = fluentJdbc.query();
        query.update("DELETE FROM type WHERE types_uuid = ?")
                .params(type.getUuid())
                .run();
    }

    public void updateName() {

    }

    public void removeTag() {

    }

    public void addTag() {

    }
}
