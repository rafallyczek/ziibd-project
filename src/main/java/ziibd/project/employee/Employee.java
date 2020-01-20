package ziibd.project.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

    //Pola
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phone;
    @Column(name = "HIRE_DATE")
    private Date date;
    @Column(name = "JOB_ID")
    private String job;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "COMMISSION_PCT")
    private Integer comm;
    @Column(name = "MANAGER_ID")
    private Integer mgr;
    @Column(name = "DEPARTMENT_ID")
    private Integer dept;

    //Konstruktory
    public Employee() {}

    public Employee(int id, String firstName, String lastName, String email, String phone, Date date, String job, int salary, int comm, int mgr, int dept) {
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

}
