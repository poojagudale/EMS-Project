package com.gpm.ems.controller;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private AttendanceService attendanceService;

    //Build add Attendance REST API
    @PostMapping
    public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto){
        AttendanceDto savedAttendance = attendanceService.createAttendance(attendanceDto);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    //Build Get Attendance REST API
    @GetMapping("{id}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable("id") Long attendanceId){
        AttendanceDto attendanceDto = attendanceService.getAttendanceById(attendanceId);
        return ResponseEntity.ok(attendanceDto);
    }

    //Build Get All Attendance REST API
    @GetMapping
    public ResponseEntity<List<AttendanceDto>> getAllAttendance(){
        List<AttendanceDto> attendance =attendanceService.getAllAttendance();
        return ResponseEntity.ok(attendance);
    }

    //Build update Attendance REST API
    @PutMapping("{id}")
    public ResponseEntity<AttendanceDto> updateAttendance(@PathVariable("id") Long attendanceId,
                                                          @RequestBody AttendanceDto updatedAttendance){
        AttendanceDto attendanceDto1 = attendanceService.updateAttendance(attendanceId, updatedAttendance);
        return  ResponseEntity.ok(attendanceDto1);
    }

}
