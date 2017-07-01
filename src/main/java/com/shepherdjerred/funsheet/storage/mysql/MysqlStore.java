package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
import com.shepherdjerred.funsheet.objects.Category;
import com.shepherdjerred.funsheet.objects.Type;
import com.shepherdjerred.funsheet.storage.Store;

import java.util.Collection;
import java.util.UUID;

public class MysqlStore implements Store {
    @Override
    public Activity getActivity(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Activity> getActivities() {
        return null;
    }

    @Override
    public Category getCategory(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Category> getCategories() {
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
}
