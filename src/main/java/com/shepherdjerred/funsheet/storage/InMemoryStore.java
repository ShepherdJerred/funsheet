package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.*;

public class InMemoryStore implements Store {

    private Map<UUID, Tag> tags;
    private Map<UUID, Type> types;
    private Map<UUID, Location> locations;
    private Map<UUID, Activity> activities;

    public InMemoryStore() {
        tags = new HashMap<>();
        types = new HashMap<>();
        locations = new HashMap<>();
        activities = new HashMap<>();
    }

    @Override
    public void addActivity(Activity activity) {
        activities.put(activity.getUuid(), activity);
    }

    @Override
    public Activity getActivity(UUID uuid) {
        return activities.get(uuid);
    }

    @Override
    public Collection<Activity> getActivities() {
        return activities.values();
    }

    @Override
    public void addTag(Tag tag) {
        tags.put(tag.getUuid(), tag);
    }

    @Override
    public Tag getTag(UUID uuid) {
        return tags.get(uuid);
    }

    @Override
    public Collection<Tag> getTags() {
        return tags.values();
    }

    @Override
    public void addType(Type type) {
        types.put(type.getUuid(), type);
    }

    @Override
    public Type getType(UUID uuid) {
        return types.get(uuid);
    }

    @Override
    public Collection<Type> getTypes() {
        return types.values();
    }

    @Override
    public void addLocation(Location location) {
        locations.put(location.getUuid(), location);
    }

    @Override
    public Location getLocation(UUID uuid) {
        return locations.get(uuid);
    }

    @Override
    public Collection<Location> getLocations() {
        return locations.values();
    }

}
