package ziibd.project.job;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class JobThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Job job;

    JobThread(Job job, String name){
        super(name);
        this.job=job;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+job+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+job.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((job.getId()==null)?null:job.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Title: "+ANSI_PURPLE+job.getJobTitle()+ANSI_RESET+" Type: "+ANSI_PURPLE+((job.getJobTitle()==null)?null:job.getJobTitle().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Minimal Salary: "+ANSI_PURPLE+job.getMinSal()+ANSI_RESET+" Type: "+ANSI_PURPLE+((job.getMinSal()==null)?null:job.getMinSal().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Maximum Salary: "+ANSI_PURPLE+job.getMaxSal()+ANSI_RESET+" Type: "+ANSI_PURPLE+((job.getMaxSal()==null)?null:job.getMaxSal().getClass().getName())+ANSI_RESET);
    }

}
