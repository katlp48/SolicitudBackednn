package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.estubeca.estubeca.entities.Comentario;

import java.util.List;

public interface  ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query(value = "SELECT * FROM comentarios c inner join posts p on c.post_id = p.id WHERE p.id=?1 order by c.id DESC ", nativeQuery = true)
    List<Comentario> findAllComentariosPostId(Long id);

    @Query("SELECT c FROM Comentario c JOIN c.post p WHERE c.post.id=?1")
    List<Comentario> findAllComentariosPostIdJPQL(Long postId);

    @Transactional(readOnly = true)
    List<Comentario> findByPostId(Long postId);
}
