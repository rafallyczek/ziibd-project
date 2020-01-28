package ziibd.project.jobgrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class JobGradeController {

    @Autowired
    private JobGradeService jobGradeService;

    //Zwróć wszystkie stopnie pracy
    @RequestMapping("/jobGrades")
    public String getJobGrades(Model model) {
        model.addAttribute("jobgrades",jobGradeService.getJobGrades());
        model.addAttribute("jobgrade",new JobGrade());
        return "jobgrades/jobGrades";
    }

    //Dodaj stopień pracy
    @PostMapping("/addJobGrade")
    public String addJobGrade(@ModelAttribute("jobgrade") JobGrade jobGrade){
        JobGradeThread jobGradeThread1 = new JobGradeThread(jobGrade,"addJobGrade(Controller) JobGradeThread");
        jobGradeThread1.start();
        jobGradeService.addJobGrade(jobGrade);
        return "redirect:/jobGrades";
    }

    //Pobierz i zapisz stopień pracy o zadanym id i zwróć widok edycji stopnia pracy
    @RequestMapping("/editJobGrade/{id}")
    public String updateJobGradeById(@PathVariable String id, Model model){
        JobGradeThread jobGradeThread2 = new JobGradeThread(jobGradeService.getJobGrade(id),"updateJobGradeById(Controller) JobGradeThread");
        jobGradeThread2.start();
        model.addAttribute("retrievedjobgrade",jobGradeService.getJobGrade(id));
        return "jobgrades/jobGradeEdit";
    }

    //Edytuj stopień pracy
    @PostMapping("/editJobGrade")
    public String updateJobGrade(@ModelAttribute("retrievedjobgrade") JobGrade jobGrade){
        JobGradeThread jobGradeThread3 = new JobGradeThread(jobGrade,"updateJobGrade(Controller) JobGradeThread");
        jobGradeThread3.start();
        jobGradeService.updateJobGrade(jobGrade);
        return "redirect:/jobGrades";
    }

    //Usuń stopień pracy
    @Transactional
    @RequestMapping("/deleteJobGrade/{id}")
    public String deleteJobGrade(@PathVariable String id){
        jobGradeService.deleteJobGrade(id);
        return "redirect:/jobGrades";
    }

}
