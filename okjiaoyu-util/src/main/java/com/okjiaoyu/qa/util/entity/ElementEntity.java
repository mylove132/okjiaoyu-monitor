package com.okjiaoyu.qa.util.entity;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-20:18:11
 * Modify date: 2018-11-20:18:11
 */
public class ElementEntity {

    private String name;
    private String type;
    private String location;
    private String timeOut;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ElementEntity{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", timeOut=" + timeOut +
                ", description='" + description + '\'' +
                '}';
    }
}
