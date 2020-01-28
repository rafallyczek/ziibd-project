package ziibd.project.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ziibd.project.department.DepartmentThread;

import javax.transaction.Transactional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Zwróć wszystkich pracowników
    @RequestMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees",employeeService.getEmployees());
        model.addAttribute("employee",new Employee());
        return "employees/employees";
    }

    //Dodaj pracownika
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        EmployeeThread employeeThread1 = new EmployeeThread(employee,"addEmployee(Controller) EmployeeThread");
        employeeThread1.start();
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    //Pobierz i zapisz pracownika o zadanym id i zwróć widok edycji pracownika
    @RequestMapping("/editEmployee/{id}")
    public String updateEmployeeById(@PathVariable int id, Model model){
        EmployeeThread employeeThread2 = new EmployeeThread(employeeService.getEmployee(id),"updateEmployeeById(Controller) EmployeeThread");
        employeeThread2.start();
        model.addAttribute("retrievedemployee",employeeService.getEmployee(id));
        return "employees/employeeEdit";
    }

    //Edytuj pracownika
    @PostMapping("/editEmployee")
    public String updateEmployee(@ModelAttribute("retrievedemployee") Employee employee){
        EmployeeThread employeeThread3 = new EmployeeThread(employee,"updateEmployee(Controller) EmployeeThread");
        employeeThread3.start();
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    //Usuń pracownika
    @Transactional
    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
