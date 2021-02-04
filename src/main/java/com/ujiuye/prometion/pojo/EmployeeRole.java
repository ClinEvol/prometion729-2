package com.ujiuye.prometion.pojo;

public class EmployeeRole {
    private Integer erid;
    private Integer role_fk;
    private Integer emp_fk;
    private String erdis;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Integer getRole_fk() {
        return role_fk;
    }

    public void setRole_fk(Integer role_fk) {
        this.role_fk = role_fk;
    }

    public Integer getEmp_fk() {
        return emp_fk;
    }

    public void setEmp_fk(Integer emp_fk) {
        this.emp_fk = emp_fk;
    }

    public String getErdis() {
        return erdis;
    }

    public void setErdis(String erdis) {
        this.erdis = erdis;
    }
}
