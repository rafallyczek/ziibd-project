package ziibd.project.region;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name="REGIONS")
public class Region {

    //Pola (Kolumny z tabeli REGIONS)
    //Klucz główny
    @Id
    @Column(name = "REGION_ID")
    private Integer id;

    //Pozostałe kolumny
    @Column(name = "REGION_NAME")
    private String reg;

    //Konstruktory
    public Region() {}

    public Region(int id, String reg) {
        this.id=id;
        this.reg=reg;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
