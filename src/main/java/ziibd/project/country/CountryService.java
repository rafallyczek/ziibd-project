package ziibd.project.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Pobierz państwo
    public Country getCountry(String id){
        return countryRepository.findById(id);
    }

    //Pobierz wszystkie państwa
    public List<Country> getCountries(){
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    //Dodaj państwo
    public void addCountry(Country country){
        countryRepository.save(country);
    }

    //Zaktualizuj państwo
    public void updateCountry(Country country){
        countryRepository.save(country);
    }

    //Usuń państwo
    public void deleteCountry(String id){
        countryRepository.deleteById(id);
    }

}
