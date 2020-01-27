package ziibd.project.jobhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    //Pobierz historię pracy
    public JobHistory getJobHistory(int id, Date startDate){
        return jobHistoryRepository.findByIdAndStartDate(id,startDate);
    }

    //Pobierz wszystkie historie pracy
    public List<JobHistory> getJobHistories(){
        List<JobHistory> jobHistories = new ArrayList<>();
        jobHistoryRepository.findAll().forEach(jobHistories::add);
        return jobHistories;
    }

    //Dodaj historię pracy
    public void addJobHistory(JobHistory jobHistory){
        jobHistoryRepository.save(jobHistory);
    }

    //Zaktualizuj historię pracy
    public void updateJobHistory(JobHistory jobHistory){
        JobHistory currentJobHistory = jobHistoryRepository.findByIdAndStartDate(jobHistory.getId(),jobHistory.getStartDate());
        currentJobHistory.setId(jobHistory.getId());
        currentJobHistory.setStartDate(jobHistory.getStartDate());
        currentJobHistory.setEndDate(jobHistory.getEndDate());
        currentJobHistory.setDept(jobHistory.getDept());
        currentJobHistory.setJob(jobHistory.getJob());
        jobHistoryRepository.save(currentJobHistory);
    }

    //Usuń historię pracy
    public void deleteJobHistory(int id, Date startDate){
        jobHistoryRepository.deleteByIdAndStartDate(id,startDate);
    }

}
