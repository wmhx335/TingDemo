package com.ruoyi.project.hrm.attendance.service;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.hrm.attendance.domain.Attendance;
import com.ruoyi.project.hrm.attendance.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-07 23:46
 * @desc
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> selectAttendanceList(Attendance attendance) {
        return attendanceMapper.selectAttendanceList(attendance);
    }

    @Override
    public int addAttendance(Attendance attendance) {
        attendance.setCreateBy(ShiroUtils.getLoginName());

        return attendanceMapper.insertAttendance(attendance);
    }

    @Override
    public Attendance selectAttendanceById(Long attendanceId) {
        return attendanceMapper.selectAttendanceById(attendanceId);
    }

    @Override
    public int updateattendance(Attendance attendance) {
        return attendanceMapper.updateattendance(attendance);
    }

    @Override
    public int removeattendanceByIds(String ids) {
        Long[] attendanceIds = Convert.toLongArray(ids);
        return attendanceMapper.deleteattendanceByIds(attendanceIds);
    }
}
