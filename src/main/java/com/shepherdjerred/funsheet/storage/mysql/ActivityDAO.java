package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import lombok.extern.log4j.Log4j2;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Mapper;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Log4j2
public class ActivityDAO implements DAO<Activity> {

    private final MysqlStore store;
    private final FluentJdbc fluentJdbc;
    private final Mapper<Activity> activityMapper;

    public ActivityDAO(Database database, MysqlStore store) {
        fluentJdbc = new FluentJdbcBuilder().connectionProvider(database.getDataSource()).build();
        this.store = store;
        // TODO don't create with every object (should be static?)
        activityMapper = rs -> {

            UUID type = rs.getString("type_uuid") == null ? null : UUID.fromString(rs.getString("type_uuid"));


            UUID location = rs.getString("location_uuid") == null ? null : UUID.fromString(rs.getString("location_uuid"));

            return new Activity(rs.getString("name"),
                    UUID.fromString(rs.getString("activity_uuid")),
                    store.getType(type),
                    rs.getInt("rating"),
                    store.getLocation(location),
                    rs.getDouble("cost"),
                    rs.getString("description")
            );
        };
    }

    @Override
    public Optional<Activity> select(UUID uuid) {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM activity WHERE activity_uuid = ?")
                .params(String.valueOf(uuid))
                .firstResult(activityMapper);
    }

    @Override
    public Collection<Activity> select() {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM activity")
                .listResult(activityMapper);
    }

    @Override
    public void insert(Activity activity) {

        String type = activity.getType() != null ? String.valueOf(activity.getType().getUuid()) : null;
        String location = activity.getLocation() != null ? String.valueOf(activity.getLocation().getUuid()) : null;

        Query query = fluentJdbc.query();
        query.update("INSERT INTO activity VALUES (?, ?, ?, ?, ?, ?, ?)")
                .params(String.valueOf(activity.getUuid()),
                        activity.getName(),
                        type,
                        activity.getRating(),
                        location,
                        activity.getCost(),
                        activity.getDescription())
                .run();
    }

    @Override
    public void drop(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("DELETE FROM activity WHERE activity_uuid = ?")
                .params(activity.getUuid())
                .run();
    }

    public void updateName(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET name = ? WHERE activity_uuid = ?")
                .params(activity.getName(),
                        activity.getUuid())
                .run();
    }

    public void updateType(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET type_uuid = ? WHERE activity_uuid = ?")
                .params(String.valueOf(activity.getType().getUuid()),
                        activity.getUuid())
                .run();
    }

    public void updateRating(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET rating = ? WHERE activity_uuid = ?")
                .params(activity.getRating(),
                        activity.getUuid())
                .run();
    }

    public void updateLocation(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET location_uuid = ? WHERE activity_uuid = ?")
                .params(String.valueOf(activity.getLocation().getUuid()),
                        activity.getUuid())
                .run();
    }

    public void updateCost(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET cost = ? WHERE activity_uuid = ?")
                .params(activity.getCost(),
                        activity.getUuid())
                .run();
    }

    public void updateDescription(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("UPDATE activity SET description = ? WHERE activity_uuid = ?")
                .params(activity.getDescription(),
                        activity.getUuid())
                .run();
    }

}
