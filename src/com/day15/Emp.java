package com.day15;
import java.math.BigDecimal;
import java.sql.Date;

public class Emp {
    private Integer empno;
    private String eName;
    private String job;
    private Date hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Integer depino;

    public Emp() {
    }

    public Emp(Integer empno, String eName, String job, Date hiredate, BigDecimal sal, BigDecimal comm, Integer depino) {
        this.empno = empno;
        this.eName = eName;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.depino = depino;
    }

    public Emp(String eName, String job, Date hiredate, BigDecimal sal, BigDecimal comm, Integer depino) {
        this.eName = eName;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.depino = depino;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Integer getDepino() {
        return depino;
    }

    public void setDepino(Integer depino) {
        this.depino = depino;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", depino=" + depino +
                '}';
    }
}
