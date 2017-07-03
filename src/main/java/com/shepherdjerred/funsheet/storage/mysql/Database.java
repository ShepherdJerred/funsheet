package com.shepherdjerred.funsheet.storage.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

public class Database {

    private HikariDataSource hikariDataSource;

    public Database(HikariConfig hikariConfig) {
        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(hikariDataSource);
        flyway.migrate();
    }

}
