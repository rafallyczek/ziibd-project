package ziibd.project.employee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmployeeThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Employee employee;

    EmployeeThread(Employee employee, String name){
        super(name);
        this.employee=employee;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+employee+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+employee.getId()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" First Name: "+ANSI_PURPLE+employee.getFirstName()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Last Name: "+ANSI_PURPLE+employee.getLastName()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Email: "+ANSI_PURPLE+employee.getEmail()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Phone: "+ANSI_PURPLE+employee.getPhone()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Date: "+ANSI_PURPLE+employee.getDate()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Salary: "+ANSI_PURPLE+employee.getSalary()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Commission %: "+ANSI_PURPLE+employee.getComm()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Manager: "+ANSI_PURPLE+employee.getMgr()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Department: "+ANSI_PURPLE+employee.getDept()+ANSI_RESET);
    }

}
