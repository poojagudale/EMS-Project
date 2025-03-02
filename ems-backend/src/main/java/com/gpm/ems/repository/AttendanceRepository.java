package com.gpm.ems.repository;

import com.gpm.ems.entity.Attendance2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance2, Long> {
}
