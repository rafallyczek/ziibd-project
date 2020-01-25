package ziibd.project.department;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@DynamicUpdate
@Table(name="DEPARTMENTS")
public class Department {

    //Pola (Kolumny z tabeli DEPARTMENTS)
    //Klucz główny
    @Id
    @Column(name="DEPARTMENT_ID")
    private Integer id;

    //Pozostałe kolumny
    @Column(name="LOCATION_ID")
    private Integer loc;
    @Column(name="MANAGER_ID")
    private Integer mgr;
    @Column(name="DEPARTMENT_NAME")
    private String name;

    //Konstruktory
    public Department() {}

    public Department(int id, String name, int mgr, int loc) {
        this.id=id;
        this.name=name;
        this.mgr=mgr;
        this.loc=loc;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
}
