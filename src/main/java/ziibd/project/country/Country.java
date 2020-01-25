package ziibd.project.country;

import org.hibernate.annotations.DynamicUpdate;
import ziibd.project.region.Region;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name="COUNTRIES")
public class Country {

    //Pola (Kolumny z tabeli COUNTRIES)
    //Klucz główny
    @Id
    @Column(name="COUNTRY_ID")
    private String id;

    //Pozostałe kolumny
    @Column(name="REGION_ID")
    private Integer reg;
    @Column(name="COUNTRY_NAME")
    private String name;

    //Konstruktory
    public Country() {}

    public Country(String id, String name, int reg) {
        this.id=id;
        this.name=name;
        this.reg=reg;
    }

    //Gettery i Settery
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReg() {
        return reg;
    }

    public void setReg(Integer reg) {
        this.reg = reg;
    }
}
