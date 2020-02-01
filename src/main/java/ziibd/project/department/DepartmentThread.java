package ziibd.project.department;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DepartmentThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Department department;

    DepartmentThread(Department department, String name){
        super(name);
        this.department=department;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+department+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+department.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((department.getId()==null)?null:department.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Name: "+ANSI_PURPLE+department.getName()+ANSI_RESET+" Type: "+ANSI_PURPLE+((department.getName()==null)?null:department.getName().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Location: "+ANSI_PURPLE+department.getLoc()+ANSI_RESET+" Type: "+ANSI_PURPLE+((department.getLoc()==null)?null:department.getLoc().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Manager: "+ANSI_PURPLE+department.getMgr()+ANSI_RESET+" Type: "+ANSI_PURPLE+((department.getMgr()==null)?null:department.getMgr().getClass().getName())+ANSI_RESET);
    }

}
