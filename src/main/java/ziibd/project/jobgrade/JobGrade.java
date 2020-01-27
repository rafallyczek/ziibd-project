package ziibd.project.jobgrade;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name="JOB_GRADES")
public class JobGrade {

    //Pola (Kolumny z tabeli JOB_GRADES)
    //Klucz główny
    @Id
    @Column(name = "GRADE_LEVEL")
    private String id;

    //Pozostałe kolumny
    @Column(name = "LOWEST_SAL")
    private Integer lowestSal;
    @Column(name = "HIGHEST_SAL")
    private Integer highestSal;

    //Konstruktory
    public JobGrade() {}

    public JobGrade(String id, int lowestSal, int highestSal) {
        this.id=id;
        this.lowestSal=lowestSal;
        this.highestSal=highestSal;
    }

    //Gettery i Settery
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLowestSal() {
        return lowestSal;
    }

    public void setLowestSal(Integer lowestSal) {
        this.lowestSal = lowestSal;
    }

    public Integer getHighestSal() {
        return highestSal;
    }

    public void setHighestSal(Integer highestSal) {
        this.highestSal = highestSal;
    }
}
