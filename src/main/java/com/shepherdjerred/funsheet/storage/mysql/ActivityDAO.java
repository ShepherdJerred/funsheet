package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Mapper;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

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

        UUID typeUuid = activity.getType() != null ? activity.getType().getUuid() : null;
        UUID locationUuid = activity.getLocation() != null ? activity.getLocation().getUuid() : null;

        Query query = fluentJdbc.query();
        query.update("INSERT INTO activity VALUES (?, ?, ?, ?, ?, ?, ?)")
                .params(String.valueOf(activity.getUuid()),
                        activity.getName(),
                        String.valueOf(typeUuid),
                        activity.getRating(),
                        String.valueOf(locationUuid),
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

    }

    public void updateType() {

    }

    public void updateRating() {

    }

    public void updateLocation() {

    }

    public void updateCost() {

    }

    public void updateDescription() {

    }

}
