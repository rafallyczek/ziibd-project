package ziibd.project.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    //Pobierz pracę
    public Job getJob(String id){
        return jobRepository.findById(id);
    }

    //Pobierz wszystkie prace
    public List<Job> getJobs(){
        List<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);
        return jobs;
    }

    //Dodaj pracę
    public void addJob(Job job){
        jobRepository.save(job);
    }

    //Zaktualizuj pracę
    public void updateJob(Job job){
        jobRepository.save(job);
    }

    //Usuń pracę
    public void deleteJob(String id){
        jobRepository.deleteById(id);
    }

}
