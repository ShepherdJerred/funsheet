package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Location;
import com.shepherdjerred.funsheet.objects.Tag;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MockStore implements Store {

    private Map<UUID, Tag> tags;
    private Map<UUID, Type> types;
    private Map<UUID, Location> locations;
    private Map<UUID, Activity> activities;

    private static List<String> mockTagNames = Arrays.asList(
            "Entertainment",
            "Culture",
            "Outdoors",
            "Shopping"
    );

    private static List<String> mockTypeNames = Arrays.asList(
            "Movie Theatre",
            "Zoo",
            "Market",
            "Mini golf",
            "Escape Room"
    );

    private static List<String> mockActivityNames = Arrays.asList(
            "Little Rock zoo",
            "Arkansas River Trail",
            "Little Rock Outlets",
            "Memphis Zoo",
            "Z82 Retrocade",
            "Mafia"
    );

    private static List<String> mockLocationNames = Arrays.asList(
            "Little Rock",
            "Searcy",
            "Memphis"
    );

    public MockStore() {
        tags = new HashMap<>();
        types = new HashMap<>();
        locations = new HashMap<>();
        activities = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Tag tag = new Tag(
                    mockTagNames.get(new Random().nextInt(mockTagNames.size())),
                    UUID.randomUUID()
            );
            tags.put(tag.getUuid(), tag);
        }

        for (int i = 0; i < 10; i++) {
            Activity activity = new Activity(
                    mockActivityNames.get(new Random().nextInt(mockActivityNames.size())),
                    UUID.randomUUID(),
                    new Type(
                            mockTypeNames.get(new Random().nextInt(mockTypeNames.size())),
                            UUID.randomUUID(),
                            new ArrayList<>()
                    ),
                    ThreadLocalRandom.current().nextInt(0, 5 + 1)
            );
            activities.put(activity.getUuid(), activity);
        }
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
    public Tag getTag(UUID uuid) {
        return tags.get(uuid);
    }

    @Override
    public Collection<Tag> getTags() {
        return tags.values();
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
    public Location getLocation(UUID uuid) {
        return locations.get(uuid);
    }

    @Override
    public Collection<Location> getLocations() {
        return locations.values();
    }

}
