package com.ruoyi.project.hrm.salary.service;

import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.hrm.salary.domain.Salary;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-07 17:04
 * @desc
 */
public interface SalaryService {
    List<Salary> selectSalaryList(Salary salary);

    int addSalary(Salary salary);

    Salary selectSalaryById(Long salaryId);

    int updateSalary(Salary salary);

    int removeSalaryByIds(String ids);
}
