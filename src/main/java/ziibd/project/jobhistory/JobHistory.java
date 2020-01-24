package ziibd.project.jobhistory;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="JOB_HISTORY")
@IdClass(JobHistoryId.class)
public class JobHistory {

    //Pola (Kolumny z tabeli EMPLOYEES)
    //Klucz główny
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Id
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    private Date startDate;
    //Pozostałe kolumny
    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    @JsonFormat(pattern = "YY/MM/dd")
    private Date endDate;
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "DEPARTMENT_ID")
    private Integer dept;

    //Konstruktory
    public JobHistory() {}

    public JobHistory(int id, Date startDate, Date endDate, String jobId, int dept) {
        this.id=id;
        this.startDate=startDate;
        this.endDate=endDate;
        this.jobId=jobId;
        this.dept=dept;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

}
