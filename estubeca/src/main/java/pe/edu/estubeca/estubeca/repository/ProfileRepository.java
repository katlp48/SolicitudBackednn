package pe.edu.estubeca.estubeca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Profile;
import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    @Query(value="SELECT p.grade as Grado, COUNT(p.grade) as Cantidad FROM profiles p GROUP BY p.grade",nativeQuery=true)
    List<String> findCantidadDeUsuariosPorGrado();
}
