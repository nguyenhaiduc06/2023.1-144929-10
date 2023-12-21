package com.example.pmchamcong.service.hrsystem.entity;

public class WorkerUnit {
    private final String name;

    public WorkerUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // Display name in ComboBox
        return name;
    }
}
