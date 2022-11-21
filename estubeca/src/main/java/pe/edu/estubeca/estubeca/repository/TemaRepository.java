package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Tema;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema,Long> {
    @Query(value = "SELECT t.* FROM temas t inner join cursos p on t.curso_id = p.id WHERE p.id=?1 order by t.position ASC ", nativeQuery = true)
    List<Tema> findAllTemasCursoId(Long id);
}
