package ziibd.project.jobhistory;

import org.springframework.data.repository.CrudRepository;
import ziibd.project.country.Country;

import java.util.Date;

public interface JobHistoryRepository extends CrudRepository<JobHistory, Integer> {

    public JobHistory findByIdAndStartDate(int id, Date startDate);

    public void deleteByIdAndStartDate(int id, Date startDate);

}
