package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Activity;
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
}
