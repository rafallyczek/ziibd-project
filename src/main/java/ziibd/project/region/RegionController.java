package ziibd.project.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziibd.project.location.Location;
import ziibd.project.location.LocationThread;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private RegionService regionService;

    //Zwróć wszystkie regiony
    @RequestMapping("/regions")
    public String getRegions(Model model) {
        model.addAttribute("regions",regionService.getRegions());
        model.addAttribute("region",new Region());
        return "regions/regions";
    }

    //Dodaj region
    @PostMapping("/addRegion")
    public String addRegion(@ModelAttribute("region") Region region){
        RegionThread regionThread1 = new RegionThread(region,"addRegion(Controller) RegionThread");
        regionThread1.start();
        regionService.addRegion(region);
        return "redirect:/regions";
    }

    //Pobierz i zapisz region o zadanym id i zwróć widok edycji regionu
    @RequestMapping("/editRegion/{id}")
    public String updateRegionById(@PathVariable int id, Model model){
        RegionThread regionThread2 = new RegionThread(regionService.getRegion(id),"updateRegionById(Controller) RegionThread");
        regionThread2.start();
        model.addAttribute("retrievedregion",regionService.getRegion(id));
        return "regions/regionEdit";
    }

    //Edytuj region
    @PostMapping("/editRegion")
    public String updateRegion(@ModelAttribute("retrievedregion") Region region){
        RegionThread regionThread3 = new RegionThread(region,"updateRegion(Controller) RegionThread");
        regionThread3.start();
        regionService.updateRegion(region);
        return "redirect:/regions";
    }

    //Usuń region
    @Transactional
    @RequestMapping("/deleteRegion/{id}")
    public String deleteRegion(@PathVariable int id){
        regionService.deleteRegion(id);
        return "redirect:/regions";
    }

}
