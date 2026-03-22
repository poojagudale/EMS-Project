package com.gpm.ems.controller;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.entity.Attendance;
import com.gpm.ems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Mark attendance
    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody AttendanceDto attendanceDto) {
        return attendanceService.markAttendance(attendanceDto);
    }

    // Get all attendance records
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    // Get attendance by employee ID
    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendanceByEmployee(@PathVariable String employeeId) {
        return attendanceService.getAttendanceByEmployee(employeeId);
    }

    // Get attendance by record ID
    @GetMapping("/{id}")
    public AttendanceDto getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }
}
