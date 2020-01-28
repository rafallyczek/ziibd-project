package ziibd.project.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziibd.project.job.Job;
import ziibd.project.job.JobThread;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    //Zwróć wszystkie lokacje
    @RequestMapping("/locations")
    public String getLocations(Model model) {
        model.addAttribute("locations",locationService.getLocations());
        model.addAttribute("location",new Location());
        return "locations/locations";
    }

    //Dodaj lokację
    @PostMapping("/addLocation")
    public String addLocation(@ModelAttribute("location") Location location){
        LocationThread locationThread1 = new LocationThread(location,"addLocation(Controller) LocationThread");
        locationThread1.start();
        locationService.addLocation(location);
        return "redirect:/locations";
    }

    //Pobierz i zapisz lokację o zadanym id i zwróć widok edycji lokacji
    @RequestMapping("/editLocation/{id}")
    public String updateLocationById(@PathVariable int id, Model model){
        LocationThread locationThread2 = new LocationThread(locationService.getLocation(id),"updateLocationById(Controller) LocationThread");
        locationThread2.start();
        model.addAttribute("retrievedlocation",locationService.getLocation(id));
        return "locations/locationEdit";
    }

    //Edytuj lokację
    @PostMapping("/editLocation")
    public String updateLocation(@ModelAttribute("retrievedlocation") Location location){
        LocationThread locationThread3 = new LocationThread(location,"updateLocation(Controller) LocationThread");
        locationThread3.start();
        locationService.updateLocation(location);
        return "redirect:/locations";
    }

    //Usuń lokację
    @Transactional
    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable int id){
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }

}
