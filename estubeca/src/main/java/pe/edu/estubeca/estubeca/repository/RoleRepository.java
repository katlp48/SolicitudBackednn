package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.estubeca.estubeca.entities.Beca;
import pe.edu.estubeca.estubeca.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
