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
        EmployeeThread employeeThread4 = new EmployeeThread(employee,"addEmployee(Service) EmployeeThread");
        employeeThread4.start();
        employeeRepository.save(employee);
    }

    //Zaktualizuj pracownika
    public void updateEmployee(Employee employee){
        EmployeeThread employeeThread5 = new EmployeeThread(employee,"updateEmployee(Service) EmployeeThread");
        employeeThread5.start();
        Employee currentEmployee = employeeRepository.findById(employee.getId()).get();
        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setDept(employee.getDept());
        currentEmployee.setJob(employee.getJob());
        currentEmployee.setMgr(employee.getMgr());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setPhone(employee.getPhone());
        currentEmployee.setDate(employee.getDate());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setComm(employee.getComm());
        employeeRepository.save(currentEmployee);
    }

    //Usuń pracownika
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }

}
