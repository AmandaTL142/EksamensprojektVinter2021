package com.example.eksamensprojektvinter2021.Models;

import java.util.Date;

public class Project {
    private String name;
    private Date projectDeadline;
    private String status;
    private double basePrice;
    private double totalPrice;
    private int totalTime;
    private int customerId;
    private int managerId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    private int projectId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(Date projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public Project(String name, Date projectDeadline, String status, double basePrice, int customerId, int managerId) {
    this.name = name;
    this.projectDeadline = projectDeadline;
    this.status = status;
    this.basePrice = basePrice;
    this.customerId = customerId;
    this.managerId = managerId;
    }

    public Project() {
    }
}
