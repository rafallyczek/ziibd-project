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

    JobHistoryThread jobHistoryThread = null;
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
        jobHistoryThread = new JobHistoryThread(jobHistory,"addJobHistoryThread");
        jobHistoryThread.start();
        jobHistoryService.addJobHistory(jobHistory);
        return "redirect:/jobHistories";
    }

    //Pobierz i zapisz historię pracy o zadanym id i zwróć widok edycji historii pracy
    @RequestMapping("/editJobHistory/{id}/{startDate}")
    public String updateJobHistoryById(@PathVariable int id, @PathVariable String startDate, Model model) throws ParseException {
        jobHistoryThread = new JobHistoryThread(jobHistoryService.getJobHistory(id,dateFormat.parse(startDate)),"editByIdJobHistoryThread");
        jobHistoryThread.start();
        model.addAttribute("retrievedjobhistory",jobHistoryService.getJobHistory(id,dateFormat.parse(startDate)));
        return "jobhistories/jobHistoryEdit";
    }

    //Edytuj historię pracy
    @PostMapping("/editJobHistory")
    public String updateJobHistory(@ModelAttribute("retrievedjobhistory") JobHistory jobHistory){
        jobHistoryThread = new JobHistoryThread(jobHistory,"editJobHistoryThread");
        jobHistoryThread.start();
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
