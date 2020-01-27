package ziibd.project.jobhistory;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class JobHistoryId implements Serializable {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public JobHistoryId() {}

    public JobHistoryId(int id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

}
