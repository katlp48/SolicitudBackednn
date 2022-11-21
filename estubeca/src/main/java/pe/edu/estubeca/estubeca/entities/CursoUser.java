package pe.edu.estubeca.estubeca.entities;

import javax.persistence.*;

@Entity
@Table(name="cursos_users")
public class CursoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Curso curso;

    @OneToOne
    private User user;

    @Column(name = "progreso")
    private Double progreso;

    @Column(name = "subscrito")
    private Boolean subscrito;

    public CursoUser() {
    }

    public CursoUser(Curso curso, User user, Double progreso, Boolean subscrito) {
        this.curso = curso;
        this.user = user;
        this.progreso = progreso;
        this.subscrito = subscrito;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getProgreso() {
        return progreso;
    }

    public void setProgreso(Double progreso) {
        this.progreso = progreso;
    }

    public Boolean getSubscrito() {
        return subscrito;
    }

    public void setSubscrito(Boolean subscrito) {
        this.subscrito = subscrito;
    }
}
