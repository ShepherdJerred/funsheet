package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.Collection;
import java.util.UUID;

public interface Store {

    Activity getActivity(UUID uuid);
    Collection<Activity> getActivities();

    Tag getTag(UUID uuid);
    Collection<Tag> getTags();

    Type getType(UUID uuid);
    Collection<Type> getTypes();

    Location getLocation(UUID uuid);
    Collection<Location> getLocations();

}
