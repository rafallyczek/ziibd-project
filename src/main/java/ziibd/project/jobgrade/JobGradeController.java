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

    JobGradeThread jobGradeThread = null;

    //Zwróć wszystkie stopnie pracy
    @RequestMapping("/jobGrades")
    public String getJobGrades(Model model) {
        model.addAttribute("jobgrades",jobGradeService.getJobGrades());
        model.addAttribute("jobgrade",new JobGrade());
        return "jobGrades/jobGrades";
    }

    //Dodaj stopień pracy
    @PostMapping("/addJobGrade")
    public String addJobGrade(@ModelAttribute("jobgrade") JobGrade jobGrade){
        jobGradeThread = new JobGradeThread(jobGrade,"addJobGradeThread");
        jobGradeThread.start();
        jobGradeService.addJobGrade(jobGrade);
        return "redirect:/jobGrades";
    }

    //Pobierz i zapisz stopień pracy o zadanym id i zwróć widok edycji stopnia pracy
    @RequestMapping("/editJobGrade/{id}")
    public String updateJobGradeById(@PathVariable String id, Model model){
        jobGradeThread = new JobGradeThread(jobGradeService.getJobGrade(id),"editByIdJobGradeThread");
        jobGradeThread.start();
        model.addAttribute("retrievedjobgrade",jobGradeService.getJobGrade(id));
        return "jobGrades/jobGradeEdit";
    }

    //Edytuj stopień pracy
    @PostMapping("/editJobGrade")
    public String updateJobGrade(@ModelAttribute("retrievedjobgrade") JobGrade jobGrade){
        jobGradeThread = new JobGradeThread(jobGrade,"editJobGradeThread");
        jobGradeThread.start();
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
