package pe.edu.estubeca.estubeca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
