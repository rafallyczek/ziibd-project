package ziibd.project.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    /*@RequestMapping("/countries/{id}")
    public Country getCountry(@PathVariable String id){
        return countryService.getCountry(id);
    }*/

    /*@RequestMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }*/

    @RequestMapping("/countries")
    public String getCountries(Model model) {
        model.addAttribute("countries",countryService.getCountries());
        return "countries";
    }

   /* @PostMapping("/countries")
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);
    }

    @PutMapping("/countries/{id}")
    public void updateCountry(@RequestBody Country country, @PathVariable int id){
        countryService.updateCountry(country);
    }

    @Transactional
    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
    }*/

}
