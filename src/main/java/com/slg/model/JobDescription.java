package com.slg.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jeff Risberg
 * @since 11/30/15
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Set<JobParameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<JobParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("JobDescription[");
        sb.append("id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", priority=");
        sb.append(priority);
        sb.append(", parameters=");
        sb.append(parameters);
        sb.append("]");

        return sb.toString();
    }
}
