package ziibd.project.job;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Job {

    //Pola (Kolumny z tabeli JOBS)
    //Klucz główny
    @Id
    @Column(name = "JOB_ID")
    private String id;

    //Pozostałe kolumny
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private Integer minSal;
    @Column(name = "MAX_SALARY")
    private Integer maxSal;

    //Konstruktory
    public Job() {}

    public Job(String id, String jobTitle, int minSal, int maxSal) {
        this.id=id;
        this.jobTitle=jobTitle;
        this.minSal=minSal;
        this.maxSal=maxSal;
    }

    //Gettery i Settery
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSal() {
        return minSal;
    }

    public void setMinSal(Integer minSal) {
        this.minSal = minSal;
    }

    public Integer getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(Integer maxSal) {
        this.maxSal = maxSal;
    }

}
