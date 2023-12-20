package com.example.pmchamcong.entity;

public class Employee {
    private String id;
    private String name;
    private Unit unit;

    public Employee(String id, String name, Unit unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
