package pe.edu.estubeca.estubeca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comentarios")

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body")
    private String body;
    @OneToOne
    private Profile autor;
    private String createdAt;

    @OneToOne
    private Post post;

    public Comentario(){

    }
    public Comentario(String body, Profile autor, String createdAt, Post post) {
        this.body = body;
        this.autor = autor;
        this.createdAt = createdAt;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public Profile getAutor() {
        return autor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAutor(Profile autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", autor=" + autor +
                ", createdAt='" + createdAt + '\'' +
                ", post=" + post +
                '}';
    }
}
