package pe.edu.estubeca.estubeca.entities;

import javax.persistence.*;

@Entity
@Table(name = "avisos")
public class Aviso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created", nullable = false)
    private String created;

    private Long user_id;


    public Aviso() {
    }

    public Aviso(String type, String title, String description, String created, Long user_id) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.created = created;
        this.user_id = user_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getUser() {
        return user_id;
    }

    public void setUser(Long user) {
        this.user_id = user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Aviso{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", user=" + user_id +
                '}';
    }
}
