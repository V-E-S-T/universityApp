package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lectors")
public class Lector implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(name = "salary")
    private int salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
