package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.CursoUser;

import java.util.List;

public interface CursoUserRepository extends JpaRepository<CursoUser, Long> {
    @Query(value = "SELECT * FROM cursos_users cu WHERE  cu.curso_id =?1 and cu.user_id=?2", nativeQuery = true)
    CursoUser findAllByCursoUser(Long id1, Long id2);
}
