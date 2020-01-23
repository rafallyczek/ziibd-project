package ziibd.project.job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {

    public Job findById(String id);

    public void deleteById(String id);

}
