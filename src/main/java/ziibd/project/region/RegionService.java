package ziibd.project.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    //Pobierz region
    public Region getRegion(int id){
        return regionRepository.findById(id).get();
    }

    //Pobierz wszystkie regiony
    public List<Region> getRegions(){
        List<Region> regions = new ArrayList<>();
        regionRepository.findAll().forEach(regions::add);
        return regions;
    }

    //Dodaj region
    public void addRegion(Region region){
        RegionThread regionThread4 = new RegionThread(region,"addRegion(Service) RegionThread");
        regionThread4.start();
        regionRepository.save(region);
    }

    //Zaktualizuj region
    public void updateRegion(Region region){
        RegionThread regionThread5 = new RegionThread(region,"updateRegion(Service) RegionThread");
        regionThread5.start();
        Region currentRegion = regionRepository.findById(region.getId()).get();
        currentRegion.setId(region.getId());
        currentRegion.setReg(region.getReg());
        regionRepository.save(currentRegion);
    }

    //Usuń region
    public void deleteRegion(int id){
        regionRepository.deleteById(id);
    }

}
