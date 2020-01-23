package ziibd.project.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/jobs/{id}")
    public Job getJob(@PathVariable String id){
        return jobService.getJob(id);
    }

    @RequestMapping("/jobs")
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    @PostMapping("/jobs")
    public void addJob(@RequestBody Job job){
        jobService.addJob(job);
    }

    @PutMapping("/jobs/{id}")
    public void updateJob(@RequestBody Job job, @PathVariable int id){
        jobService.updateJob(job);
    }

    @Transactional
    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
    }

}
