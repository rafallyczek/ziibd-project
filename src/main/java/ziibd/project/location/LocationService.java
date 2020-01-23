package ziibd.project.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //Pobierz lokację
    public Location getLocation(int id){
        return locationRepository.findById(id).get();
    }

    //Pobierz wszystkie lokacje
    public List<Location> getLocations(){
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    //Dodaj lokację
    public void addLocation(Location location){
        locationRepository.save(location);
    }

    //Zaktualizuj lokację
    public void updateLocation(Location location){
        locationRepository.save(location);
    }

    //Usuń lokację
    public void deleteLocation(int id){
        locationRepository.deleteById(id);
    }

}
