package com.ruoyi.project.hrm.attendance.mapper;

import com.ruoyi.project.hrm.attendance.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttendanceMapper {
    List<Attendance> selectAttendanceList(Attendance attendance);

    int insertAttendance(Attendance attendance);

    Attendance selectAttendanceById(Long attendanceId);

    int updateattendance(Attendance attendance);

    int deleteattendanceByIds(@Param("attendanceIds")Long[] attendanceIds);
}
