package ziibd.project.country;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CountryThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    Country country;

    CountryThread(Country country, String name){
        super(name);
        this.country=country;
    }

    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Thread "+getName()+" is running."+ANSI_RESET);
        System.out.println("Printing "+country+" field values:");
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Id: "+ANSI_PURPLE+country.getId()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Name: "+ANSI_PURPLE+country.getName()+ANSI_RESET);
        System.out.println(ANSI_CYAN+getName()+ANSI_RESET+" Region: "+ANSI_PURPLE+country.getReg()+ANSI_RESET);
    }

}
