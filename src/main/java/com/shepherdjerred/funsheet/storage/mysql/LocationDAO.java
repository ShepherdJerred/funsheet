package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Location;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class LocationDAO implements DAO<Location> {
    @Override
    public Optional<Location> select(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Collection<Location> select() {
        return null;
    }

    @Override
    public void insert(Location type) {

    }

    @Override
    public void drop(Location type) {

    }
}
