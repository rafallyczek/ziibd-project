package ziibd.project.region;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RegionThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Region region;

    RegionThread(Region region, String name){
        super(name);
        this.region=region;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+region+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+region.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((region.getId()==null)?null:region.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Name: "+ANSI_PURPLE+region.getReg()+ANSI_RESET+" Type: "+ANSI_PURPLE+((region.getReg()==null)?null:region.getReg().getClass().getName())+ANSI_RESET);
    }

}
