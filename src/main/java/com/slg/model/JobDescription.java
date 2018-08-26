package com.slg.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jeff Risberg
 * @since 11/30/15
 */
@Data
public class JobDescription {
    protected Integer id;
    protected String name;
    protected String url;
    protected String command;
    protected int priority;
    protected Set<JobParameter> parameters;

    public JobDescription() {
        this.parameters = new HashSet<JobParameter>();
    }

    public JobDescription(Integer id, String name, String url, String command, int priority, Set parameters) {
        this();
        this.id = id;
        this.name = name;
        this.url = url;
        this.command = command;
        this.priority = priority;
        this.parameters = parameters;
    }
}
