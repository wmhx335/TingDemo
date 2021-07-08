package com.ruoyi.project.hrm.salary.service;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.hrm.salary.domain.Salary;
import com.ruoyi.project.hrm.salary.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wmhx335
 * @create 2021-07-07 17:04
 * @desc
 */
@Service
public class SalaryServiceImpl implements SalaryService{

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> selectSalaryList(Salary salary) {
        return salaryMapper.selectSalaryList(salary);
    }

    @Override
    public int addSalary(Salary salary) {
        salary.setCreateBy(ShiroUtils.getLoginName());

        return salaryMapper.insertSalary(salary);
    }

    @Override
    public Salary selectSalaryById(Long salaryId) {
        return salaryMapper.selectSalaryById(salaryId);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public int removeSalaryByIds(String ids) {
        Long[] salaryIds = Convert.toLongArray(ids);
        return salaryMapper.deleteSalaryByIds(salaryIds);
    }

}
