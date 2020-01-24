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

    //Zwróć wszystkie państwa
    @RequestMapping("/countries")
    public String getCountries(Model model) {
        model.addAttribute("countries",countryService.getCountries());
        model.addAttribute("country",new Country());
        return "countries";
    }

    //Dodaj państwo
    @PostMapping("/add")
    public String addCountry(@ModelAttribute("country") Country country){
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    //Pobierz i zapisz państwo o zadanym id i zwróć widok edycji państwa
    @RequestMapping("/edit/{id}")
    public String updateCountryById(@PathVariable String id, Model model){
        model.addAttribute("retrievedcountry",countryService.getCountry(id));
        return "countryEdit";
    }

    //Edytuj państwo
    @PostMapping("/edit")
    public String updateCountry(@ModelAttribute("retrievedcountry") Country country){
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    //Usuń państwo
    @Transactional
    @RequestMapping("/delete/{id}")
    public String deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

}
