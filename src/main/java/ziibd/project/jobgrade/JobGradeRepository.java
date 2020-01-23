package ziibd.project.jobgrade;

import org.springframework.data.repository.CrudRepository;

public interface JobGradeRepository extends CrudRepository<JobGrade, Integer> {

    public JobGrade findById(String id);

    public void deleteById(String id);

}
