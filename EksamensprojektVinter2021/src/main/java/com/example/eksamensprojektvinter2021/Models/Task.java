package com.example.eksamensprojektvinter2021.Models;

public class Task {
    private int taskID;
    private String title;
    private String description;
    private double estimatedTime;
    private double timeUsed;
    private String status;

    public Task() {
    }

    public Task(int taskID, String title, String description, double estimatedTime, double timeUsed, String status) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.timeUsed = timeUsed;
        this.status = status;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(double timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
