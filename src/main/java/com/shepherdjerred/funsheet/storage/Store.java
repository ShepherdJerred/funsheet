package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.Collection;
import java.util.UUID;

public interface Store {

    void addActivity(Activity activity);
    Activity getActivity(UUID uuid);
    Collection<Activity> getActivities();
    void deleteActivity(UUID uuid);
    void updateActivity(Activity activity);

    void addTag(Tag tag);
    Tag getTag(UUID uuid);
    Collection<Tag> getTags();
    void deleteTag(UUID uuid);
    void updateTag(Tag tag);

    void addType(Type type);
    Type getType(UUID uuid);
    Collection<Type> getTypes();
    void deleteType(UUID uuid);
    void updateType(Type type);

    void addLocation(Location location);
    Location getLocation(UUID uuid);
    Collection<Location> getLocations();
    void deleteLocation(UUID uuid);
    void updateLocation(Location location);

}
