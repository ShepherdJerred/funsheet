package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.storage.Store;

import java.util.Collection;
import java.util.UUID;

public class MysqlStore implements Store {

    private final Database database;
    private final ActivityDAO activityDAO;
    private final LocationDAO locationDAO;
    private final TypeDAO typeDAO;
    private final TagDAO tagDAO;

    public MysqlStore(Database database) {
        this.database = database;
        activityDAO = new ActivityDAO(database, this);
        locationDAO = new LocationDAO(database);
        typeDAO = new TypeDAO(database, this);
        tagDAO = new TagDAO(database);
    }

    @Override
    public void addActivity(Activity activity) {
        activityDAO.insert(activity);
    }

    @Override
    public Activity getActivity(UUID uuid) {
        return activityDAO.select(uuid).orElse(null); // TODO Return something other than null
    }

    @Override
    public Collection<Activity> getActivities() {
        return activityDAO.select();
    }

    @Override
    public void addTag(Tag tag) {
        tagDAO.insert(tag);
    }

    @Override
    public Tag getTag(UUID uuid) {
        return tagDAO.select(uuid).orElse(null); // TODO Return something other than null
    }

    @Override
    public Collection<Tag> getTags() {
        return tagDAO.select();
    }

    @Override
    public void addType(Type type) {
        typeDAO.insert(type);
    }

    @Override
    public Type getType(UUID uuid) {
        return typeDAO.select(uuid).orElse(null); // TODO Return something other than null
    }

    @Override
    public Collection<Type> getTypes() {
        return typeDAO.select();
    }

    @Override
    public void addLocation(Location location) {
        locationDAO.insert(location);
    }

    @Override
    public Location getLocation(UUID uuid) {
        return locationDAO.select(uuid).orElse(null); // TODO Return something other than null
    }

    @Override
    public Collection<Location> getLocations() {
        return locationDAO.select();
    }

}
