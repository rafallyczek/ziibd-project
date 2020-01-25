package ziibd.project.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Zwróć wszystkie departamenty
    @RequestMapping("/departments")
    public String getDepartments(Model model) {
        model.addAttribute("departments",departmentService.getDepartments());
        model.addAttribute("department",new Department());
        return "departments/departments";
    }

    //Dodaj departament
    @PostMapping("/addDepartment")
    public String addDepartment(@ModelAttribute("department") Department department){
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }

    //Pobierz i zapisz departament o zadanym id i zwróć widok edycji departamentu
    @RequestMapping("/editDepartment/{id}")
    public String updateDepartmentById(@PathVariable int id, Model model){
        model.addAttribute("retrieveddepartment",departmentService.getDepartment(id));
        return "departments/departmentEdit";
    }

    //Edytuj departament
    @PostMapping("/editDepartment")
    public String updateDepartment(@ModelAttribute("retrieveddepartment") Department department){
        departmentService.updateDepartment(department);
        return "redirect:/departments";
    }

    //Usuń departament
    @Transactional
    @RequestMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }

}
