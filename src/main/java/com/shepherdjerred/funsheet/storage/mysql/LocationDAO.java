package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Location;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Mapper;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class LocationDAO implements DAO<Location> {

    private final FluentJdbc fluentJdbc;
    private static Mapper<Location> locationMapper;

    public LocationDAO(Database database) {
        fluentJdbc = new FluentJdbcBuilder().connectionProvider(database.getDataSource()).build();
        // TODO don't create with every object (should be static?)
        locationMapper = rs -> new Location(
                rs.getString("name"),
                UUID.fromString(rs.getString("location_uuid")),
                rs.getString("placeId")
        );
    }

    @Override
    public Optional<Location> select(UUID uuid) {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM location WHERE location_uuid = ?")
                .params(String.valueOf(uuid))
                .firstResult(locationMapper);
    }

    @Override
    public Collection<Location> select() {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM location")
                .listResult(locationMapper);
    }

    @Override
    public void insert(Location location) {
        Query query = fluentJdbc.query();
        query.update("INSERT INTO location VALUES (?, ?, ?)")
                .params(String.valueOf(location.getUuid()),
                        location.getName(),
                        location.getPlaceId())
                .run();
    }

    @Override
    public void drop(Location location) {
        Query query = fluentJdbc.query();
        query.update("DELETE FROM location WHERE location_uuid = ?")
                .params(location.getUuid())
                .run();
    }

    public void updateName() {

    }

    public void updatePlaceId() {

    }
}
