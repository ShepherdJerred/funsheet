package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.storage.Store;

import java.util.Collection;
import java.util.UUID;

public class MysqlStore implements Store {

    private Database database;

    public MysqlStore(Database database) {
        this.database = database;
    }

    @Override
    public Activity getActivity(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Activity> getActivities() {
        return null;
    }

    @Override
    public Tag getTag(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Tag> getTags() {
        return null;
    }

    @Override
    public Type getType(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Type> getTypes() {
        return null;
    }

    @Override
    public Location getLocation(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Location> getLocations() {
        return null;
    }

}
