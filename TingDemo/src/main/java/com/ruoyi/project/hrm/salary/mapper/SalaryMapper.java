package com.ruoyi.project.hrm.salary.mapper;

import com.ruoyi.project.hrm.salary.domain.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalaryMapper {
    List<Salary> selectSalaryList(Salary salary);

    int insertSalary(Salary salary);

    Salary selectSalaryById(Long salaryId);

    int updateSalary(Salary salary);

    int deleteSalaryByIds(@Param("salaryIds")Long[] salaryIds);
}
