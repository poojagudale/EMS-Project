package com.gpm.ems.mapper;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.entity.Attendance2;

public class AttendanceMapper {

    public static AttendanceDto mapToAttendanceDto(Attendance2 attendance2){
        return new AttendanceDto(
                attendance2.getId(),
                attendance2.getCloth(),
                attendance2.getPresentAbsent()
        );
    }

    public static Attendance2 mapToAttendance2(AttendanceDto attendanceDto){
        return new Attendance2(
                attendanceDto.getId(),
                attendanceDto.getPresentAbsent(),
                attendanceDto.getCloth()
        );


    }
}
