package ziibd.project.department;

import org.springframework.data.repository.CrudRepository;
import ziibd.project.employee.Employee;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
