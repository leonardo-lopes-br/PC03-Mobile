package com.example.todov1app;

import java.io.Serializable;

enum TaskPriority {
    low,
    medium,
    high,
}

public class Task implements Serializable {
    String name, description;
    TaskPriority priority;

    public Task(String name, String description, TaskPriority priority) {
        this.name = name;
        this.description = description;
        this.priority = priority != null ? priority : TaskPriority.low;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() { return this.priority; }

    public void setPriority(TaskPriority priority) { this.priority = priority; }

    @Override
    public String toString() {
        return getName();
    }
}
