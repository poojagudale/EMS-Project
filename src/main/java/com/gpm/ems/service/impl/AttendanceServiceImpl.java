package com.gpm.ems.service.impl;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.entity.Attendance;
import com.gpm.ems.mapper.AttendanceMapper;
import com.gpm.ems.repository.AttendanceRepository;
import com.gpm.ems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance markAttendance(AttendanceDto attendanceDto) {
        Attendance attendance = AttendanceMapper.toEntity(attendanceDto);

        // Generate Date and Time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        attendance.setDate(now.format(dateFormatter));
        attendance.setTime(now.format(timeFormatter));

        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(String employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    @Override
    public AttendanceDto getAttendanceById(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        return optionalAttendance.map(AttendanceMapper::toDto).orElse(null);
    }
}
