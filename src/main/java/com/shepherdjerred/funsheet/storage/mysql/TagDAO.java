package com.shepherdjerred.funsheet.storage.mysql;

import com.shepherdjerred.funsheet.objects.Tag;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Mapper;
import org.codejargon.fluentjdbc.api.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class TagDAO implements DAO<Tag> {

    private final FluentJdbc fluentJdbc;
    private static Mapper<Tag> tagMapper;

    public TagDAO(Database database) {
        fluentJdbc = new FluentJdbcBuilder().connectionProvider(database.getDataSource()).build();
        // TODO don't create with every object (should be static?)
        tagMapper = rs -> new Tag(
                rs.getString("name"),
                UUID.fromString(rs.getString("tag_uuid"))
        );
    }

    @Override
    public Optional<Tag> select(UUID uuid) {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM tag WHERE tag_uuid = ?")
                .params(String.valueOf(uuid))
                .firstResult(tagMapper);
    }

    @Override
    public Collection<Tag> select() {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM tag")
                .listResult(tagMapper);
    }

    public Collection<Tag> selectTagsOfType(UUID typeUuid) {
        Query query = fluentJdbc.query();
        return query.select("SELECT * FROM type_tags INNER JOIN tag ON type_tags.tag_uuid = tag.tag_uuid WHERE type_uuid = ?")
                .params(String.valueOf(typeUuid))
                .listResult(tagMapper);
    }

    @Override
    public void insert(Tag tag) {
        Query query = fluentJdbc.query();
        query.update("INSERT INTO tag VALUES (?, ?)")
                .params(String.valueOf(tag.getUuid()),
                        tag.getName())
                .run();
    }

    @Override
    public void drop(Tag tag) {
        Query query = fluentJdbc.query();
        query.update("DELETE FROM tag WHERE tag_uuid = ?")
                .params(tag.getUuid())
                .run();
    }

    // TODO
    @Override
    public void update(Tag tag) {
        Query query = fluentJdbc.query();
        query.update("UPDATE tag SET name = ? WHERE tag_uuid = ?")
                .params(tag.getName(),
                        String.valueOf(tag.getUuid()))
                .run();
    }
}
