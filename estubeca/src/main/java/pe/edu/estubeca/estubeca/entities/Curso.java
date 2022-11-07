package pe.edu.estubeca.estubeca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    /*@ManyToMany
    @JoinTable(name = "cursos_users",
            joinColumns = {@JoinColumn(name = "curso_id",
                    referencedColumnName = "id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "id",nullable = false)}
    )
    private List<User> users = new ArrayList<>();*/
    @Column(name="name")
    private String name;
    @Column(name="description", length = 400, nullable = false)
    private String description;
    @Column(name="finished",nullable = false)
    private Boolean finished;
    @Column(name="cost")
    private Float cost;
    public Curso(){

    }

    public Curso(String name, String description, Boolean finished, Float cost) {
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.cost = cost;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                ", cost=" + cost +
                '}';
    }
}
