package com.gpm.ems.service.impl;

import com.gpm.ems.dto.AttendanceDto;
import com.gpm.ems.dto.EmployeeDto;
import com.gpm.ems.entity.Attendance2;
import com.gpm.ems.exception.ResourceNotFoundException;
import com.gpm.ems.mapper.AttendanceMapper;
import com.gpm.ems.repository.AttendanceRepository;
import com.gpm.ems.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceRepository attendanceRepository;

    @Override
    public AttendanceDto createAttendance(AttendanceDto attendanceDto) {

        Attendance2 attendance2 = AttendanceMapper.mapToAttendance2(attendanceDto);
        Attendance2 savedAttendance = attendanceRepository.save(attendance2);
        return AttendanceMapper.mapToAttendanceDto(savedAttendance);

    }

    @Override
    public AttendanceDto getAttendanceById(Long attendanceId) {
        Attendance2 attendance2 = attendanceRepository.findById(attendanceId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists: "+attendanceId));
        return AttendanceMapper.mapToAttendanceDto(attendance2);
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        List<Attendance2> attendance2s = attendanceRepository.findAll();
        return attendance2s.stream().map((attendance) -> AttendanceMapper.mapToAttendanceDto(attendance))
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDto updateAttendance(Long attendanceId, AttendanceDto updatedAttendance) {
        Attendance2 attendance2 = attendanceRepository.findById(attendanceId).orElseThrow(
                () -> new ResourceNotFoundException("Attendance not exist with this id: "+attendanceId)
        );

        attendance2.setCloth(updatedAttendance.getCloth());
        attendance2.setPresentAbsent(updatedAttendance.getPresentAbsent());

        Attendance2 updatedAttendanceObj = attendanceRepository.save(attendance2);

        return AttendanceMapper.mapToAttendanceDto(updatedAttendanceObj);
    }
}
