package com.shepherdjerred.funsheet.storage;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Category;
import com.shepherdjerred.funsheet.objects.Type;

import java.util.Collection;
import java.util.UUID;

public interface Store {

    Activity getActivity(UUID uuid);
    Collection<Activity> getActivities();

    Category getCategory(UUID uuid);
    Collection<Category> getCategories();

    Type getType(UUID uuid);
    Collection<Type> getTypes();

}
