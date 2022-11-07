package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.estubeca.estubeca.entities.Curso;


import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query(value = "SELECT p.name as Nombre, p.last_name as Apellido, u.email, p.phone as Telefono FROM cursos c, users u, cursos_users cu, profiles p WHERE c.id=cu.curso_id and u.id=cu.user_id and p.user_id=u.id and c.name=?1",nativeQuery= true)
    List<String> ListUsuariosPorCursoJPQL(String name);

    @Query(value = "SELECT c.name, COUNT(u.id) From cursos c, users u, cursos_users cu WHERE  c.id=cu.curso_id and u.id=cu.user_id Group by c.name", nativeQuery = true)
    List<String> ListNumeroUsuarioPorCursoJPQL();


}
