package ziibd.project.jobhistory;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ziibd.project.department.Department;
import ziibd.project.employee.Employee;
import ziibd.project.job.Job;
import ziibd.project.region.Region;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="JOB_HISTORY")
@IdClass(JobHistoryId.class)
public class JobHistory {

    //Pola (Kolumny z tabeli JOB_HISTORY)
    //Klucz główny
    @Id
    @Column(name="EMPLOYEE_ID")
    private Integer id;
    @Id
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    private Date startDate;

    //Pozostałe kolumny
    @Column(name="DEPARTMENT_ID")
    private Integer dept;
    @Column(name="JOB_ID")
    private Integer job;
    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    @JsonFormat(pattern = "YY/MM/dd")
    private Date endDate;

    //Konstruktory
    public JobHistory() {}

    public JobHistory(int id, Date startDate, Date endDate, int job, int dept) {
        this.id=id;
        this.startDate=startDate;
        this.endDate=endDate;
        this.job=job;
        this.dept=dept;
    }

    //Gettery i Settery
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
