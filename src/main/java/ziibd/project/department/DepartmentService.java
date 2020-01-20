package ziibd.project.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    //Pobierz departament
    public Department getDepartment(int id){
        return departmentRepository.findById(id).get();
    }

    //Pobierz wszystkie departamenty
    public List<Department> getDepartments(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    //Dodaj departament
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    //Zaktualizuj departament
    public void updateDepartment(Department department){
        departmentRepository.save(department);
    }

    //Usuń departament
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

}
