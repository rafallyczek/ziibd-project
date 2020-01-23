package ziibd.project.jobhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @RequestMapping("/jobhistories/{id}")
    public JobHistory getJobHistory(@PathVariable int id){
        return jobHistoryService.getJobHistory(id);
    }

    @RequestMapping("/jobhistories")
    public List<JobHistory> getJobHistories() {
        return jobHistoryService.getJobHistories();
    }

    @PostMapping("/jobhistories")
    public void addJobHistory(@RequestBody JobHistory jobHistory){
        jobHistoryService.addJobHistory(jobHistory);
    }

    @PutMapping("/jobhistories/{id}")
    public void updateJobHistory(@RequestBody JobHistory jobHistory, @PathVariable int id){
        jobHistoryService.updateJobHistory(jobHistory);
    }

    @DeleteMapping("/jobhistories/{id}")
    public void deleteJobHistory(@PathVariable int id){
        jobHistoryService.deleteJobHistory(id);
    }

}
