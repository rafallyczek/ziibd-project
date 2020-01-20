package ziibd.project.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Pobierz pracownika
    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    //Pobierz wszystkich pracowników
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    //Dodaj pracownika
    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    //Zaktualizuj pracownika
    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    //Usuń pracownika
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }

}
