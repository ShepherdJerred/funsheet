package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Tag;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class TagDAO implements DAO<Tag> {
    @Override
    public Optional<Tag> select(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Collection<Tag> select() {
        return null;
    }

    @Override
    public void insert(Tag type) {

    }

    @Override
    public void drop(Tag type) {

    }
}
