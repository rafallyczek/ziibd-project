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
        LocationThread locationThread4 = new LocationThread(location,"addLocation(Service) LocationThread");
        locationThread4.start();
        locationRepository.save(location);
    }

    //Zaktualizuj lokację
    public void updateLocation(Location location){
        LocationThread locationThread5 = new LocationThread(location,"updateLocation(Service) LocationThread");
        locationThread5.start();
        Location currentLocation = locationRepository.findById(location.getId()).get();
        currentLocation.setId(location.getId());
        currentLocation.setCountry(location.getCountry());
        currentLocation.setStreet(location.getStreet());
        currentLocation.setPostalCode(location.getPostalCode());
        currentLocation.setCity(location.getCity());
        currentLocation.setState(location.getState());
        locationRepository.save(currentLocation);
    }

    //Usuń lokację
    public void deleteLocation(int id){
        locationRepository.deleteById(id);
    }

}
