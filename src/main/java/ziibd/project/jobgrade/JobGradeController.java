package ziibd.project.jobgrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class JobGradeController {

    @Autowired
    private JobGradeService jobGradeService;

    @RequestMapping("/jobgrades/{id}")
    public JobGrade getJobGrade(@PathVariable String id){
        return jobGradeService.getJobGrade(id);
    }

    @RequestMapping("/jobgrades")
    public List<JobGrade> getJobGrades() {
        return jobGradeService.getJobGrades();
    }

    @PostMapping("/jobgrades")
    public void addJobGrade(@RequestBody JobGrade jobGrade){
        jobGradeService.addJobGrade(jobGrade);
    }

    @PutMapping("/jobgrades/{id}")
    public void updateJobGrade(@RequestBody JobGrade jobGrade, @PathVariable int id){
        jobGradeService.updateJobGrade(jobGrade);
    }

    @Transactional
    @DeleteMapping("/jobgrades/{id}")
    public void deleteJobGrade(@PathVariable String id){
        jobGradeService.deleteJobGrade(id);
    }

}
