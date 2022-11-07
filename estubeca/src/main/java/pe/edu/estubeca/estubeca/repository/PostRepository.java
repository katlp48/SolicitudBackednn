package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {


    @Query(value="SELECT * FROM posts WHERE  published=?1", nativeQuery = true)
    List<Post> findByPublishedSQL(boolean published);

    @Query(value = "SELECT p FROM posts p WHERE p.published=?1", nativeQuery = true)
    List<Post> findByPublishedJPQL(boolean published);
    List<Post> findByPublished(boolean published);
    List<Post> findByTitleContaining (String title);

    @Query(value="select * from posts ORDER BY id DESC;", nativeQuery = true)
    List<Post> postsDescendente();


}

