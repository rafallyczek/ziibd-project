package ziibd.project.employee;

import ziibd.project.department.Department;

public class EmployeeThread extends Thread {

    Employee employee;

    EmployeeThread(Employee employee, String name){
        super(name);
        this.employee=employee;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+employee+" field values:");
        System.out.println("Employee Id: "+employee.getId());
        System.out.println("Employee First Name: "+employee.getFirstName());
        System.out.println("Employee Last Name: "+employee.getLastName());
        System.out.println("Employee Email: "+employee.getEmail());
        System.out.println("Employee Phone: "+employee.getPhone());
        System.out.println("Employee Date: "+employee.getDate());
        System.out.println("Employee Salary: "+employee.getSalary());
        System.out.println("Employee Commission %: "+employee.getComm());
        System.out.println("Employee Manager: "+employee.getMgr());
        System.out.println("Employee Department: "+employee.getDept());
        System.out.println("----------------------------------");
    }

}
