package com.ruoyi.project.hrm.salary.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * @author wmhx335
 * @create 2021-07-07 17:06
 * @desc
 */
public class Salary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long salaryId;
    private String basicSalary;
    private String perquisite;
    private String insurance;
    private String salarySort;
    private String status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getPerquisite() {
        return perquisite;
    }

    public void setPerquisite(String perquisite) {
        this.perquisite = perquisite;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getSalarySort() {
        return salarySort;
    }

    public void setSalarySort(String salarySort) {
        this.salarySort = salarySort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
