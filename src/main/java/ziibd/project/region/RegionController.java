package ziibd.project.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping("/regions/{id}")
    public Region getRegion(@PathVariable int id){
        return regionService.getRegion(id);
    }

    @RequestMapping("/regions")
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @PostMapping("/regions")
    public void addRegion(@RequestBody Region region){
        regionService.addRegion(region);
    }

    @PutMapping("/regions/{id}")
    public void updateRegion(@RequestBody Region region, @PathVariable int id){
        regionService.updateRegion(region);
    }

    @DeleteMapping("/regions/{id}")
    public void deleteRegion(@PathVariable int id){
        regionService.deleteRegion(id);
    }

}
