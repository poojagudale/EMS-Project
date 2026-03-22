package com.gpm.ems.mapper;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.entity.Attendance;

public class AttendanceMapper {

    // Entity to DTO
    public static AttendanceDto toDto(Attendance attendance) {
        return new AttendanceDto(
                attendance.getEmployeeId(),
                attendance.getEmployeeName(),
                attendance.getDate(),
                attendance.getTime(),
                attendance.getPresentAbsent()
        );
    }

    // DTO to Entity
    public static Attendance toEntity(AttendanceDto attendanceDto) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(attendanceDto.getEmployeeId());
        attendance.setEmployeeName(attendanceDto.getEmployeeName());
        attendance.setDate(attendanceDto.getDate());
        attendance.setTime(attendanceDto.getTime());
        attendance.setPresentAbsent(attendanceDto.getPresentAbsent());
        return attendance;
    }
}
