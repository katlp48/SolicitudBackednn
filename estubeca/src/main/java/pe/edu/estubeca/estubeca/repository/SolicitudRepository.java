package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.estubeca.estubeca.entities.Post;
import pe.edu.estubeca.estubeca.entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud,Long> {

}
