package com.slg.config;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;

/**
 * App config backed by Archaius.
 *
 * @author Jeff Risberg
 * @since 12/04/15
 */
public class ArchaiusAppConfig implements AppConfig {

    /**
     * Constructor
     */
    public ArchaiusAppConfig() {
    }

    public String getString(final String key, final String defaultValue) {
        return DynamicPropertyFactory.getInstance().getStringProperty(key, defaultValue).get();
    }

    public int getInt(final String key, final int defaultValue) {
        return DynamicPropertyFactory.getInstance().getIntProperty(key, defaultValue).get();
    }

    public long getLong(final String key, final int defaultValue) {
        return DynamicPropertyFactory.getInstance().getLongProperty(key, defaultValue).get();
    }

    public double getDouble(final String key, final double defaultValue) {
        return DynamicPropertyFactory.getInstance().getDoubleProperty(key, defaultValue).get();
    }

    public boolean getBoolean(final String key, final boolean defaultValue) {
        return DynamicPropertyFactory.getInstance().getBooleanProperty(key, defaultValue).get();
    }

    /**
     * Sets an instance-level override.
     *
     * @param key   the specified key.
     * @param value the specified value.
     */
    public void setOverrideProperty(final String key, final Object value) {
        ((ConcurrentCompositeConfiguration) ConfigurationManager.getConfigInstance()).setOverrideProperty(key, value);
    }
}
