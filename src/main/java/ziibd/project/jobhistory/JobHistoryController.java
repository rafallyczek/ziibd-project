package ziibd.project.jobhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziibd.project.jobgrade.JobGrade;
import ziibd.project.jobgrade.JobGradeThread;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //Zwróć wszystkie historie pracy
    @RequestMapping("/jobHistories")
    public String getJobHistories(Model model) {
        model.addAttribute("jobhistories",jobHistoryService.getJobHistories());
        model.addAttribute("jobhistory",new JobHistory());
        return "jobhistories/jobHistory";
    }

    //Dodaj historię pracy
    @PostMapping("/addJobHistory")
    public String addJobHistory(@ModelAttribute("jobhistory") JobHistory jobHistory){
        JobHistoryThread jobHistoryThread1 = new JobHistoryThread(jobHistory,"addJobHistory(Controller) JobHistoryThread");
        jobHistoryThread1.start();
        jobHistoryService.addJobHistory(jobHistory);
        return "redirect:/jobHistories";
    }

    //Pobierz i zapisz historię pracy o zadanym id i zwróć widok edycji historii pracy
    @RequestMapping("/editJobHistory/{id}/{startDate}")
    public String updateJobHistoryById(@PathVariable int id, @PathVariable String startDate, Model model) throws ParseException {
        JobHistoryThread jobHistoryThread2 = new JobHistoryThread(jobHistoryService.getJobHistory(id,dateFormat.parse(startDate)),"updateJobHistoryById(Controller) JobHistoryThread");
        jobHistoryThread2.start();
        model.addAttribute("retrievedjobhistory",jobHistoryService.getJobHistory(id,dateFormat.parse(startDate)));
        return "jobhistories/jobHistoryEdit";
    }

    //Edytuj historię pracy
    @PostMapping("/editJobHistory")
    public String updateJobHistory(@ModelAttribute("retrievedjobhistory") JobHistory jobHistory){
        JobHistoryThread jobHistoryThread3 = new JobHistoryThread(jobHistory,"updateJobHistory(Controller) JobHistoryThread");
        jobHistoryThread3.start();
        jobHistoryService.updateJobHistory(jobHistory);
        return "redirect:/jobHistories";
    }

    //Usuń historię pracy
    @Transactional
    @RequestMapping("/deleteJobHistory/{id}/{startDate}")
    public String deleteJobHistory(@PathVariable int id,@PathVariable String startDate) throws ParseException {
        jobHistoryService.deleteJobHistory(id,dateFormat.parse(startDate));
        return "redirect:/jobHistories";
    }

}
