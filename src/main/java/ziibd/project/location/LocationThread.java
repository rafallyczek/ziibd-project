package ziibd.project.location;

public class LocationThread extends Thread {

    Location location;

    LocationThread(Location location, String name){
        super(name);
        this.location=location;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+location+" field values:");
        System.out.println("Location Id: "+location.getId());
        System.out.println("Location Country: "+location.getCountry());
        System.out.println("Location Street: "+location.getStreet());
        System.out.println("Location Postal Code: "+location.getPostalCode());
        System.out.println("Location City: "+location.getCity());
        System.out.println("Location State: "+location.getState());
        System.out.println("----------------------------------");
    }

}
