package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>  {
    @Query(value="SELECT u.role_id_role as Rol, COUNT(u.role_id_role) as Contador FROM users u GROUP BY u.role_id_role",nativeQuery=true)
    List<String> findCantidadDeUsuariosPorRol();


    @Query(value="SELECT * FROM users WHERE id = (SELECT MAX(id) FROM users)",nativeQuery=true)
    User getUserMaxId();

    
}
