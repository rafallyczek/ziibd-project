package ziibd.project.jobhistory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class JobHistoryThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    JobHistory jobHistory;

    JobHistoryThread(JobHistory jobHistory, String name){
        super(name);
        this.jobHistory=jobHistory;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+jobHistory+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+jobHistory.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobHistory.getId()==null)?null:jobHistory.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Start Date: "+ANSI_PURPLE+jobHistory.getStartDate()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobHistory.getStartDate()==null)?null:jobHistory.getStartDate().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Department: "+ANSI_PURPLE+jobHistory.getDept()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobHistory.getDept()==null)?null:jobHistory.getDept().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Job: "+ANSI_PURPLE+jobHistory.getJob()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobHistory.getJob()==null)?null:jobHistory.getJob().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" End Date: "+ANSI_PURPLE+jobHistory.getEndDate()+ANSI_RESET+" Type: "+ANSI_PURPLE+((jobHistory.getEndDate()==null)?null:jobHistory.getEndDate().getClass().getName())+ANSI_RESET);
    }

}
