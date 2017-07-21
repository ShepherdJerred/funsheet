package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Type;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class TypeDAO implements DAO<Type> {
    @Override
    public Optional<Type> select(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Collection<Type> select() {
        return null;
    }

    @Override
    public void insert(Type type) {

    }

    @Override
    public void drop(Type type) {

    }
}
