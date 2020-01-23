package ziibd.project.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="LOCATIONS")
public class Location {

    //Pola (Kolumny z tabeli EMPLOYEES)
    //Klucz główny
    @Id
    @Column(name = "LOCATION_ID")
    private Integer id;
    //Pozostałe kolumny
    @Column(name = "STREET_ADDRESS")
    private String street;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String state;
    @Column(name = "COUNTRY_ID")
    private String country;

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
