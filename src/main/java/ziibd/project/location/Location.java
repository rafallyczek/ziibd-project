package ziibd.project.location;

import org.hibernate.annotations.DynamicUpdate;
import ziibd.project.country.Country;
import ziibd.project.region.Region;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name="LOCATIONS")
public class Location {

    //Pola (Kolumny z tabeli LOCATIONS)
    //Klucz główny
    @Id
    @Column(name = "LOCATION_ID")
    private Integer id;

    //Pozostałe kolumny
    @Column(name="COUNTRY_ID")
    private String country;
    @Column(name = "STREET_ADDRESS")
    private String street;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String state;

    //Konstruktory
    public Location() {}

    public Location(int id, String street, String postalCode, String city, String state, String country) {
        this.id=id;
        this.street=street;
        this.postalCode=postalCode;
        this.city=city;
        this.state=state;
        this.country=country;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
