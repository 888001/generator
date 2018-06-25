package com.cittt.generator.vo;

public class ReqParamVO {
    private String defaultValue;
    private String description;
    private String name;
    private String require;
    private String type;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
