package com.ruoyi.project.hrm.attendance.service;

import com.ruoyi.project.hrm.attendance.domain.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> selectAttendanceList(Attendance attendance);

    int addAttendance(Attendance attendance);

    Attendance selectAttendanceById(Long attendanceId);

    int updateattendance(Attendance attendance);

    int removeattendanceByIds(String ids);
}
