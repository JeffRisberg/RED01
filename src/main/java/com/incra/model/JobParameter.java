package com.incra.model;

/**
 * @author Jeff Risberg
 * @since 12/16/15
 */
public class JobParameter {
    protected String name;
    protected Object value;

    public JobParameter() {
    }

    public JobParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("(");
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append(")");

        return sb.toString();
    }
}
