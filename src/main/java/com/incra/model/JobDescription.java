package com.incra.model;

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

    public JobDescription() {
    }

    public JobDescription(Integer id, String name, String url, String command, int priority) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.command = command;
        this.priority = priority;
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("JobDescription[");
        sb.append("id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", priority=");
        sb.append(priority);
        sb.append("]");

        return sb.toString();
    }
}
