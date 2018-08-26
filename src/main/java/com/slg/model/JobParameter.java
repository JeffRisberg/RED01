package com.slg.model;

import lombok.Data;

/**
 * @author Jeff Risberg
 * @since 12/16/15
 */
@Data
public class JobParameter {
    protected String name;
    protected Object value;

    public JobParameter() {
    }

    public JobParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
