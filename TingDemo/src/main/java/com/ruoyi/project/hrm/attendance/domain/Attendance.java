package com.ruoyi.project.hrm.attendance.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * @author wmhx335
 * @create 2021-07-07 23:45
 * @desc
 */
public class Attendance extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long attendanceId;
    private String basicHours;
    private String actualHours;
    private String overtime;
    private String attendanceSort;
    private String status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getBasicHours() {
        return basicHours;
    }

    public void setBasicHours(String basicHours) {
        this.basicHours = basicHours;
    }

    public String getActualHours() {
        return actualHours;
    }

    public void setActualHours(String actualHours) {
        this.actualHours = actualHours;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getAttendanceSort() {
        return attendanceSort;
    }

    public void setAttendanceSort(String attendanceSort) {
        this.attendanceSort = attendanceSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
