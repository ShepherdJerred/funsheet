package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Category;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MockStore implements Store {

    private Map<UUID, Category> categories;
    private Map<UUID, Type> types;
    private Map<UUID, Activity> activities;

    public MockStore() {
        categories = new HashMap<>();
        types = new HashMap<>();
        activities = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Category category = new Category(
                    "CategoryName",
                    UUID.randomUUID()
            );
            categories.put(category.getUuid(), category);
        }

        for (int i = 0; i < 10; i++) {
            Activity activity = new Activity(
                    "ActivityName",
                    UUID.randomUUID(),
                    new Type(
                            "ActivityCategoryName",
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
    public Category getCategory(UUID uuid) {
        return categories.get(uuid);
    }

    @Override
    public Collection<Category> getCategories() {
        return categories.values();
    }

    @Override
    public Type getType(UUID uuid) {
        return types.get(uuid);
    }

    @Override
    public Collection<Type> getTypes() {
        return types.values();
    }

}
