package ziibd.project.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ziibd.project.employee.Employee;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments/{id}")
    public Department getDepartment(@PathVariable int id){
        return departmentService.getDepartment(id);
    }

    @RequestMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping("/departments")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@RequestBody Department department, @PathVariable int id){
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
    }

}
