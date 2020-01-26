package ziibd.project.country;

import org.springframework.context.annotation.Scope;

public class CountryThread extends Thread {

    Country country;

    CountryThread(Country country, String name){
        super(name);
        this.country=country;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+country+" field values:");
        System.out.println("Country Id: "+country.getId());
        System.out.println("Country Name: "+country.getName());
        System.out.println("Country Region: "+country.getReg());
        System.out.println("----------------------------------");
    }

}
