package ziibd.project.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    //Zwróć wszystkie państwa
    @RequestMapping("/countries")
    public String getCountries(Model model) {
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("country",new Country());
        return "countries/countries";
    }

    //Dodaj państwo
    @PostMapping("/addCountry")
    public String addCountry(@ModelAttribute("country") Country country){
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    //Pobierz i zapisz państwo o zadanym id i zwróć widok edycji państwa
    @RequestMapping("/editCountry/{id}")
    public String updateCountryById(@PathVariable String id, Model model){
        model.addAttribute("retrievedcountry",countryService.getCountry(id));
        return "countries/countryEdit";
    }

    //Edytuj państwo
    @PostMapping("/editCountry")
    public String updateCountry(@ModelAttribute("retrievedcountry") Country country){
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    //Usuń państwo
    @Transactional
    @RequestMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

}
