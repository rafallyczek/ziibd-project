package ziibd.project.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Country {

    //Pola (Kolumny z tabeli DEPARTMENTS)
    //Klucz główny
    @Id
    @Column(name="COUNTRY_ID")
    private String id;
    //Pozostałe kolumny
    @Column(name="COUNTRY_NAME")
    private String name;
    @Column(name="REGION_ID")
    private Integer reg;

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
