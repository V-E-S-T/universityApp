package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_department")
    private String name_department;

    @Column(name = "head_department")
    private String head_department;

    @ManyToMany
    @JoinTable(name = "lectors_department",
    joinColumns = @JoinColumn(name = "department_id"),
    inverseJoinColumns = @JoinColumn(name = "lectors_id"))
    private Set<Lector> lectors = new HashSet<Lector>();

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    public int getId() {
        return id;
    }

    public String getName_department() {
        return name_department;
    }

    public String getHead_department() {
        return head_department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public void setHead_department(String head_department) {
        this.head_department = head_department;
    }
}
