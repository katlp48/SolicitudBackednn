package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Aviso;


import java.util.List;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

    @Query(value = "SELECT * FROM avisos a WHERE a.user_id=?1 OR a.type = 'general' order by a.id DESC ", nativeQuery = true)
    List<Aviso> findAllAvisosByUser(Long id);
}
