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
        CountryThread countryThread4 = new CountryThread(country,"addCountry(Service) CountryThread");
        countryThread4.start();
        countryRepository.save(country);
    }

    //Zaktualizuj państwo
    public void updateCountry(Country country){
        CountryThread countryThread5 = new CountryThread(country,"updateCountry(Service) CountryThread");
        countryThread5.start();
        Country currentCountry = countryRepository.findById(country.getId());
        currentCountry.setName(country.getName());
        currentCountry.setReg(country.getReg());
        countryRepository.save(currentCountry);
    }

    //Usuń państwo
    public void deleteCountry(String id){
        countryRepository.deleteById(id);
    }

}
