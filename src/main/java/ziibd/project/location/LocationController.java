package ziibd.project.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/locations/{id}")
    public Location getLocation(@PathVariable int id){
        return locationService.getLocation(id);
    }

    @RequestMapping("/locations")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @PutMapping("/locations/{id}")
    public void updateLocation(@RequestBody Location location, @PathVariable int id){
        locationService.updateLocation(location);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable int id){
        locationService.deleteLocation(id);
    }

}
