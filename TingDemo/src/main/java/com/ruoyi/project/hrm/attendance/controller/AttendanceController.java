package com.ruoyi.project.hrm.attendance.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.hrm.attendance.domain.Attendance;
import com.ruoyi.project.hrm.attendance.service.AttendanceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-07 23:37
 * @desc
 */
@Controller
@RequestMapping("/hrm/attendance")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceService attendanceService;
    private String prefix = "hrm/attendance";

    @RequiresPermissions("hrm:attendance:view")
    @GetMapping
    public String view(){
        return prefix + "/attendance";
    }

    @RequiresPermissions("hrm:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Attendance attendance){
        // 分页处理
        startPage();
        // 查询， 通过服务代码，调用Mapper逻辑，查询数据库中的数据。
        List<Attendance> list = attendanceService.selectAttendanceList(attendance);
        return getDataTable(list);
    }

    /**
     * 新增公告类型页面跳转
     */
    @GetMapping("/add")
    public String toAdd(){
        return prefix+ "/add";
    }

    @RequiresPermissions("hrm:attendance:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@Validated Attendance attendance){

        // 调用服务逻辑，新增数据到数据库。
        // toAjax是父类型BaseController中定义的方法。 根据新增行数判断是否成功。新增数据行数大于0，成功。反之失败。
        return toAjax(attendanceService.addAttendance(attendance));
    }

    /**
     * 跳转修改公告类型
     */
    @GetMapping("/edit/{attendanceId}")
    public String edit(@PathVariable("attendanceId") Long attendanceId, Model model)
    {
        model.addAttribute("attendance", attendanceService.selectAttendanceById(attendanceId));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("hrm:attendance:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Attendance attendance)
    {
        return toAjax(attendanceService.updateattendance(attendance));
    }

    @PostMapping("/remove")
    @RequiresPermissions("hrm:attendance:remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        try{
            return toAjax(attendanceService.removeattendanceByIds(ids));
        }catch(Exception e){
            return error(e.getMessage());
        }
    }
}
