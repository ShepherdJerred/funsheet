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
    public Optional<Activity> getActivity(UUID uuid) {
        return Optional.of(activities.getOrDefault(uuid, null));
    }

    @Override
    public Collection<Activity> getActivities() {
        return activities.values();
    }

    @Override
    public void deleteActivity(UUID uuid) {
        activities.remove(uuid);
    }

    @Override
    public void updateActivity(Activity activity) {
        // Nothing needs to be done
    }

    @Override
    public void addTag(Tag tag) {
        tags.put(tag.getUuid(), tag);
    }

    @Override
    public Optional<Tag> getTag(UUID uuid) {
        return Optional.of(tags.getOrDefault(uuid, null));
    }

    @Override
    public Collection<Tag> getTags() {
        return tags.values();
    }

    @Override
    public void deleteTag(UUID uuid) {
        tags.remove(uuid);
    }

    @Override
    public void updateTag(Tag tag) {
        // Nothing needs to be done
    }

    @Override
    public void addType(Type type) {
        types.put(type.getUuid(), type);
    }

    @Override
    public Optional<Type> getType(UUID uuid) {
        return Optional.of(types.getOrDefault(uuid, null));
    }

    @Override
    public Collection<Type> getTypes() {
        return types.values();
    }

    @Override
    public void deleteType(UUID uuid) {
        types.remove(uuid);
    }

    @Override
    public void updateType(Type type) {
        // Nothing needs to be done
    }

    @Override
    public void addLocation(Location location) {
        locations.put(location.getUuid(), location);
    }

    @Override
    public Optional<Location> getLocation(UUID uuid) {
        return Optional.of(locations.getOrDefault(uuid, null));
    }

    @Override
    public Collection<Location> getLocations() {
        return locations.values();
    }

    @Override
    public void deleteLocation(UUID uuid) {
        locations.remove(uuid);
    }

    @Override
    public void updateLocation(Location location) {
        // Nothing needs to be done
    }

}
