package com.slg.config;

import com.google.common.annotations.VisibleForTesting;

/**
 * Application Config
 *
 * @author Jeff Risberg
 * @since 12/04/15
 */
public interface AppConfig {

    String getString(String key, String defaultValue);

    int getInt(String key, int defaultValue);

    long getLong(String key, int defaultValue);

    double getDouble(String key, double defaultValue);

    boolean getBoolean(String key, boolean defaultValue);

    /**
     * Sets an instance-level override.
     *
     * @param key   the specified key.
     * @param value the specified value.
     */
    @VisibleForTesting
    void setOverrideProperty(String key, Object value);
}
