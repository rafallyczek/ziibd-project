package ziibd.project.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziibd.project.employee.Employee;
import ziibd.project.employee.EmployeeThread;

import javax.transaction.Transactional;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    JobThread jobThread = null;

    //Zwróć wszystkich pracowników
    @RequestMapping("/jobs")
    public String getJobs(Model model) {
        model.addAttribute("jobs",jobService.getJobs());
        model.addAttribute("job",new Job());
        return "jobs/jobs";
    }

    //Dodaj pracownika
    @PostMapping("/addJob")
    public String addJob(@ModelAttribute("job") Job job){
        jobThread = new JobThread(job,"addJobThread");
        jobThread.start();
        jobService.addJob(job);
        return "redirect:/jobs";
    }

    //Pobierz i zapisz pracownika o zadanym id i zwróć widok edycji pracownika
    @RequestMapping("/editJob/{id}")
    public String updateJobById(@PathVariable String id, Model model){
        jobThread = new JobThread(jobService.getJob(id),"editByIdJobThread");
        jobThread.start();
        model.addAttribute("retrievedjob",jobService.getJob(id));
        return "jobs/jobEdit";
    }

    //Edytuj pracownika
    @PostMapping("/editJob")
    public String updateJob(@ModelAttribute("retrievedjob") Job job){
        jobThread = new JobThread(job,"editJobThread");
        jobThread.start();
        jobService.updateJob(job);
        return "redirect:/jobs";
    }

    //Usuń pracownika
    @Transactional
    @RequestMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }

}
