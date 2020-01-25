package ziibd.project.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ziibd.project.department.Department;
import ziibd.project.job.Job;
import ziibd.project.region.Region;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

    //Pola (Kolumny z tabeli EMPLOYEES)
    //Klucz główny
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;

    //Pozostałe kolumny
    @Column(name="DEPARTMENT_ID")
    private Integer dept;
    @Column(name="JOB_ID")
    private Integer job;
    @Column(name="MANAGER_ID")
    private Integer mgr;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phone;
    @Column(name = "HIRE_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    @JsonFormat(pattern = "yy/MM/dd")
    private Date date;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "COMMISSION_PCT")
    private Integer comm;

    //Konstruktory
    public Employee() {}

    public Employee(int id, String firstName, String lastName, String email, String phone, Date date, int job, int salary, int comm, int mgr, int dept) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.date=date;
        this.job=job;
        this.salary=salary;
        this.comm=comm;
        this.mgr=mgr;
        this.dept=dept;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
}
