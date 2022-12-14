package com.atguigu.pojo;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 19:07
 * @ClassName Dept
 * @Version 1.0
 */
public class Dept {
    private Integer did;
    // t_dept表该列名为dept_name
    private String deptName;

    private List<Emp> empList;  // 多对一：使用集合的形式

    public Dept() {
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}
