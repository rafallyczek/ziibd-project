package ziibd.project.jobgrade;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class JobGradeThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    JobGrade jobGrade;

    JobGradeThread(JobGrade jobGrade, String name){
        super(name);
        this.jobGrade=jobGrade;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+jobGrade+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+jobGrade.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobGrade.getId()==null)?null:jobGrade.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Lowest Salary: "+ANSI_PURPLE+jobGrade.getLowestSal()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobGrade.getLowestSal()==null)?null:jobGrade.getLowestSal().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Highest Salary: "+ANSI_PURPLE+jobGrade.getHighestSal()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobGrade.getHighestSal()==null)?null:jobGrade.getHighestSal().getClass().getName())+ANSI_RESET);
    }

}
