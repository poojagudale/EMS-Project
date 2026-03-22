package com.gpm.ems.service;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    // Mark attendance and auto-generate date & time
    Attendance markAttendance(AttendanceDto attendanceDto);

    // Get all attendance records
    List<Attendance> getAllAttendance();

    // Get attendance records of a specific employee
    List<Attendance> getAttendanceByEmployee(String employeeId);

    // Get attendance by ID (DTO response)
    AttendanceDto getAttendanceById(Long id);
}
