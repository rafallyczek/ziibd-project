package ziibd.project.jobhistory;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class JobHistoryId implements Serializable {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "YY/MM/DD")
    private Date startDate;

    public JobHistoryId() {}

    public JobHistoryId(int id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

}
