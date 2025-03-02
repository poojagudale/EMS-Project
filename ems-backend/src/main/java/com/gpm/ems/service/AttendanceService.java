package com.gpm.ems.service;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.dto.EmployeeDto;

import java.util.List;

public interface AttendanceService {
    AttendanceDto createAttendance(AttendanceDto attendanceDto);

    AttendanceDto getAttendanceById(Long attendanceId);

    List<AttendanceDto> getAllAttendance();

    AttendanceDto updateAttendance(Long attendanceId, AttendanceDto updatedAttendance);
}
