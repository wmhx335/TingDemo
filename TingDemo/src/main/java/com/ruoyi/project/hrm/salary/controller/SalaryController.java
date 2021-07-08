package com.ruoyi.project.hrm.salary.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.hrm.salary.domain.Salary;
import com.ruoyi.project.hrm.salary.service.SalaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-07 16:56
 * @desc
 */
@Controller
@RequestMapping("/hrm/salary")
public class SalaryController extends BaseController {

    @Autowired
    private SalaryService salaryService;
    private String prefix = "hrm/salary";

    @RequiresPermissions("hrm:salary:view")
    @GetMapping
    public String view(){
        return prefix + "/salary";
    }

    @RequiresPermissions("hrm:salary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Salary salary){
        // 分页处理
        startPage();
        // 查询， 通过服务代码，调用Mapper逻辑，查询数据库中的数据。
        List<Salary> list = salaryService.selectSalaryList(salary);

        return getDataTable(list);
    }

    /**
     * 新增公告类型页面跳转
     */
    @GetMapping("/add")
    public String toAdd(){
        return prefix+ "/add";
    }

    @RequiresPermissions("hrm:salary:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@Validated Salary salary){

        // 调用服务逻辑，新增数据到数据库。
        // toAjax是父类型BaseController中定义的方法。 根据新增行数判断是否成功。新增数据行数大于0，成功。反之失败。
        return toAjax(salaryService.addSalary(salary));
    }

    /**
     * 跳转修改公告类型
     */
    @GetMapping("/edit/{salaryId}")
    public String edit(@PathVariable("salaryId") Long salaryId, Model model)
    {
        model.addAttribute("salary", salaryService.selectSalaryById(salaryId));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("hrm:salary:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Salary salary)
    {
        return toAjax(salaryService.updateSalary(salary));
    }

    @PostMapping("/remove")
    @RequiresPermissions("hrm:salary:remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        try{
            return toAjax(salaryService.removeSalaryByIds(ids));
        }catch(Exception e){
            return error(e.getMessage());
        }
    }
}
