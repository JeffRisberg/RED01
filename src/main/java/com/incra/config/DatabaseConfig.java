package com.incra.config;

/**
 * Database configuration.
 *
 * @author Enriko Aryanto
 * @since 11/19/15.
 */
public class DatabaseConfig {
    public final static String MYSQL = "mysql";
    public final static String POSTGRES = "postgres";
    public final static String REDSHIFTP = "redshiftp";
    public final static String REDSHIFTR = "redshiftr";

    private final AppConfig appConfig;
    private final String prefix;

    DatabaseConfig(final AppConfig appConfig, final String prefix) {
        this.appConfig = appConfig;
        this.prefix = prefix;
    }

    public String getDriverClass() {
        return appConfig.getString(prefix + ".driverClass", null);
    }

    public String getUsername() {
        return appConfig.getString(prefix + ".username", null);
    }

    public String getPassword() {
        return appConfig.getString(prefix + ".password", null);
    }

    public String getServer() {
        return appConfig.getString(prefix + ".server", null);
    }

    public String getServer(final int clusterNumber) {
        return String.format(appConfig.getString(prefix + ".server", null), clusterNumber);
    }

    public String getDb() {
        return appConfig.getString(prefix + ".db", null);
    }

    public int getConnectionMin() {
        return appConfig.getInt(prefix + ".connection.min", 0);
    }

    public int getConnectionMax() {
        return appConfig.getInt(prefix + ".connection.max", 5);
    }

    public long getConnectionTimeoutMs() {
        return appConfig.getLong(prefix + ".connection.timeout.ms", 30000);
    }

    public long getConnectionIdleTimeoutMs() {
        return appConfig.getLong(prefix + ".connection.idle.timeout.ms", 600000);
    }

    public long getConnectionMaxLifetimeMs() {
        return appConfig.getLong(prefix + ".connection.max.lifetime.ms", 1800000);
    }

    public String getConnectionTestQuery() {
        return appConfig.getString(prefix + ".connection.test.query", "SELECT 1");
    }
}
