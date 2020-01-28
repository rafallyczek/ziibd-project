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

    //Zwróć wszystkie prace
    @RequestMapping("/jobs")
    public String getJobs(Model model) {
        model.addAttribute("jobs",jobService.getJobs());
        model.addAttribute("job",new Job());
        return "jobs/jobs";
    }

    //Dodaj pracę
    @PostMapping("/addJob")
    public String addJob(@ModelAttribute("job") Job job){
        JobThread jobThread1 = new JobThread(job,"addJob(Controller) JobThread");
        jobThread1.start();
        jobService.addJob(job);
        return "redirect:/jobs";
    }

    //Pobierz i zapisz pracę o zadanym id i zwróć widok edycji pracy
    @RequestMapping("/editJob/{id}")
    public String updateJobById(@PathVariable String id, Model model){
        JobThread jobThread2 = new JobThread(jobService.getJob(id),"updateJobById(Controller) JobThread");
        jobThread2.start();
        model.addAttribute("retrievedjob",jobService.getJob(id));
        return "jobs/jobEdit";
    }

    //Edytuj pracę
    @PostMapping("/editJob")
    public String updateJob(@ModelAttribute("retrievedjob") Job job){
        JobThread jobThread3 = new JobThread(job,"updateJob(Controller) JobThread");
        jobThread3.start();
        jobService.updateJob(job);
        return "redirect:/jobs";
    }

    //Usuń pracę
    @Transactional
    @RequestMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }

}
