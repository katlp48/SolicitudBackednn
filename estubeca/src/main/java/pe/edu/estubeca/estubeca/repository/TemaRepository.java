package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Tema;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema,Long> {


}
