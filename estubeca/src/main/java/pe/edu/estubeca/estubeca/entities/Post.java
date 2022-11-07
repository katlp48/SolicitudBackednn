package pe.edu.estubeca.estubeca.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;




import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "slug", length = 200)
    private String slug;
    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;
    //@Lob
    @Column(name = "body", length = 1200, nullable = false)
    private String body;
    @Column(name="tags")
    public String tagList;
    @Column(name = "createdAt", nullable = false)
    private String createdAt;
    @Column(name = "updatedAt")
    private String updatedAt;
    @Column(name = "favorite", nullable = false)
    private Boolean favorite;
    @Column(name = "favoritesCount", nullable = false)
    private Long favoritesCount;
    @OneToOne
    private Profile author;

    @Column(name = "published")
    private boolean published;

    /*@OneToMany(mappedBy = "post", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Comentario> comentarios;*/


    public Post(String slug, String title, String description, String body, String tagList, String createdAt, String updatedAt, Boolean favorite, Long favoritesCount, Profile author, boolean published) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.body = body;
        this.tagList = tagList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.favorite = favorite;
        this.favoritesCount = favoritesCount;
        this.author = author;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", tagList=" + tagList +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", favorite=" + favorite +
                ", favoritesCount=" + favoritesCount +
                ", author=" + author +
                ", published=" + published +
                '}';
    }

    public Post(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Long getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Long favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public Profile getAuthor() {
        return author;
    }

    public void setAuthor(Profile author) {
        this.author = author;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

   /* private static String stringArrayTOString(String[] input) {
        StringBuffer sb =new StringBuffer("");
        int i=0;
        for(String value:input) {

            if(i!=0) {
                sb.append(",");
            }
            sb.append(value);
            i++;
        }
        return sb.toString();
    }

    private static String[] stringToStringArray(String input) {
        String[] output = input.split(",");
        return output;
    }*/
}
