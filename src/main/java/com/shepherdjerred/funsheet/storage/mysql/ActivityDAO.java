package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ActivityDAO implements DAO<Activity> {

    private final FluentJdbc fluentJdbc;

    public ActivityDAO(Database database) {
        fluentJdbc = new FluentJdbcBuilder().connectionProvider(database.getDataSource()).build();
    }

    @Override
    public Optional<Activity> select(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Collection<Activity> select() {
        return null;
    }

    @Override
    public void insert(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("INSERT INTO activities VALUES (?, ?, ?, ?, ?, ?, ?)")
                .params(activity.getUuid(),
                        activity.getName(),
                        activity.getType().getUuid(),
                        activity.getRating(),
                        activity.getLocation().getUuid(),
                        activity.getCost(),
                        activity.getDescription())
                .run();
    }

    @Override
    public void drop(Activity activity) {
        Query query = fluentJdbc.query();
        query.update("DELETE FROM activities WHERE activity_uuid = ?")
                .params(activity.getUuid())
                .run();
    }

    public void updateName(Activity activity) {

    }

}
