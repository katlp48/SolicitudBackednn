package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>  {

    @Query(value="SELECT c.name, COUNT(u.id)From users u, profiles p WHERE  c.id=cu.curso_id and u.id=cu.user_id Group by c.name",nativeQuery=true)
    List<String> findCantidadDeUsuariosPorGrado();

    @Query(value="SELECT * FROM users WHERE id = (SELECT MAX(id) FROM users)",nativeQuery=true)
    User getUserMaxId();

    
}
