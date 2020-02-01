package ziibd.project.location;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LocationThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Location location;

    LocationThread(Location location, String name){
        super(name);
        this.location=location;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+location+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+location.getId()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getId()==null)?null:location.getId().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Country: "+ANSI_PURPLE+location.getCountry()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getCountry()==null)?null:location.getCountry().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Street: "+ANSI_PURPLE+location.getStreet()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getStreet()==null)?null:location.getStreet().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Postal Code: "+ANSI_PURPLE+location.getPostalCode()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getPostalCode()==null)?null:location.getPostalCode().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" City: "+ANSI_PURPLE+location.getCity()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getCity()==null)?null:location.getCity().getClass().getName())+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" State: "+ANSI_PURPLE+location.getState()+ANSI_RESET+" Type: "+ANSI_PURPLE+((location.getState()==null)?null:location.getState().getClass().getName())+ANSI_RESET);
    }

}
