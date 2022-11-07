package pe.edu.estubeca.estubeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.estubeca.estubeca.entities.Etiqueta;

import java.util.List;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

    List<Etiqueta> findByNameContaining(String name);
    @Query(value="select e.name from etiquetas e",nativeQuery=true)
    List<String> listaEtiquetas();
}
