package pe.edu.estubeca.estubeca.entities;

import javax.persistence.*;

@Entity
@Table(name = "avisos")
public class Aviso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAviso;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;

    public Aviso(String type, String title, String description) {
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public Aviso(){
    }

    public Long getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Long idAviso) {
        this.idAviso = idAviso;
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
                "idAviso=" + idAviso +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
