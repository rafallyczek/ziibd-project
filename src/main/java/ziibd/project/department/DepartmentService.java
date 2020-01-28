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
        DepartmentThread departmentThread4 = new DepartmentThread(department,"addDepartment(Service) DepartmentThread");
        departmentThread4.start();
        departmentRepository.save(department);
    }

    //Zaktualizuj departament
    public void updateDepartment(Department department){
        DepartmentThread departmentThread5 = new DepartmentThread(department,"updateDepartment(Service) DepartmentThread");
        departmentThread5.start();
        Department currentDepartment = departmentRepository.findById(department.getId()).get();
        currentDepartment.setName(department.getName());
        currentDepartment.setLoc(department.getLoc());
        currentDepartment.setMgr(department.getMgr());
        departmentRepository.save(currentDepartment);
    }

    //Usuń departament
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

}
