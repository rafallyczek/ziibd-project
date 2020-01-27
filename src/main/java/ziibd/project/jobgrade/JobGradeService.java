package ziibd.project.jobgrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobGradeService {

    @Autowired
    private JobGradeRepository jobGradeRepository;

    //Pobierz stopień pracy
    public JobGrade getJobGrade(String id){
        return jobGradeRepository.findById(id);
    }

    //Pobierz wszystkie stopnie pracy
    public List<JobGrade> getJobGrades(){
        List<JobGrade> jobGrades = new ArrayList<>();
        jobGradeRepository.findAll().forEach(jobGrades::add);
        return jobGrades;
    }

    //Dodaj stopień pracy
    public void addJobGrade(JobGrade jobGrade){
        jobGradeRepository.save(jobGrade);
    }

    //Zaktualizuj stopień pracy
    public void updateJobGrade(JobGrade jobGrade){
        JobGrade currentJobGrade = jobGradeRepository.findById(jobGrade.getId());
        currentJobGrade.setId(jobGrade.getId());
        currentJobGrade.setLowestSal(jobGrade.getLowestSal());
        currentJobGrade.setHighestSal(jobGrade.getHighestSal());
        jobGradeRepository.save(currentJobGrade);
    }

    //Usuń stopień pracy
    public void deleteJobGrade(String id){
        jobGradeRepository.deleteById(id);
    }

}
