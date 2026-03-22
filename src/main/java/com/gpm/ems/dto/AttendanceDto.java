package com.gpm.ems.dto;

public class AttendanceDto {

    private String employeeId;
    private String employeeName;
    private String date;
    private String time;
    private String presentAbsent;

    public AttendanceDto() {
    }

    public AttendanceDto(String employeeId, String employeeName, String date, String time, String presentAbsent) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.date = date;
        this.time = time;
        this.presentAbsent = presentAbsent;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPresentAbsent() {
        return presentAbsent;
    }

    public void setPresentAbsent(String presentAbsent) {
        this.presentAbsent = presentAbsent;
    }
}
