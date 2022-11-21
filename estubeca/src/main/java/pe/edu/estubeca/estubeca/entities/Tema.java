package pe.edu.estubeca.estubeca.entities;


import javax.persistence.*;

@Entity
@Table(name = "temas")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private Long position;

    @Column(name="title", length=100, nullable = false)
    private String title;

    @Column(name="description", length=400, nullable = false)
    private String description;

    @Column(name="body", length=1200, nullable = false)
    private String body;

    @Column(name="video", length=1000, nullable = false)
    private String video;

    @OneToOne
    private Curso curso;

    public Tema(Long position, String title, String description, String body, String video, Curso curso) {
        this.position = position;
        this.title = title;
        this.description = description;
        this.body = body;
        this.video = video;
        this.curso = curso;
    }

    public Tema() {

    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
