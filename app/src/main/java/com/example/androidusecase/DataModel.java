package com.example.androidusecase;

public class DataModel {

    int image, statusIcon;
    String leaveType, dateTime, name, role, numberOfDays,dateRange, status;

    public DataModel(int image, String leaveType, String dateTime, String name, String role, String numberOfDays, String dateRange, String status, int statusIcon) {
        this.image = image;
        this.leaveType = leaveType;
        this.dateTime = dateTime;
        this.name = name;
        this.role = role;
        this.numberOfDays = numberOfDays;
        this.dateRange = dateRange;
        this.statusIcon = statusIcon;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getStatusIcon() { return statusIcon; }

    public void setStatusIcon(int statusIcon) { this.statusIcon = statusIcon;}

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
