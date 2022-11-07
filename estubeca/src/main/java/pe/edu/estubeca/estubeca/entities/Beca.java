package pe.edu.estubeca.estubeca.entities;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="becas")

public class Beca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tags")
    private String tagList;
    @Column(name="title", length=60, nullable = false)
    private String title;
    //@Lob
    @Column(name= "imgUrl", length =500,nullable = false)
    private String imgUrl;
    //@Lob
    @Column(name="description", length =1000,nullable = false)
    private String description;
    //@Lob
    @Column(name="requisitos", length =2000, nullable = false)
    private String requisitos;
    @Column(name="telefono", length=20, nullable = false)
    private String telefono;
    @Column(name="urlPage", length =500, nullable = false)
    private String urlPage;
    //@Lob
    @Column(name="beneficios",length =2000,nullable = false)
    private String beneficios;

    public Beca(String title, String imgUrl, String description, String requisitos, String telefono, String urlPage, String beneficios,String tagList) {
        this.tagList = tagList;
        this.title = title;
        this.imgUrl = imgUrl;
        this.description = description;
        this.requisitos = requisitos;
        this.telefono = telefono;
        this.urlPage = urlPage;
        this.beneficios = beneficios;
    }

    public Beca(){

    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return "Beca{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", description='" + description + '\'' +
                ", requisitos='" + requisitos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", urlPage='" + urlPage + '\'' +
                ", beneficios='" + beneficios + '\'' +
                '}';
    }

}
