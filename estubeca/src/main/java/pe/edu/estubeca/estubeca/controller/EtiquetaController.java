package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Etiqueta;
import pe.edu.estubeca.estubeca.entities.User;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.EtiquetaRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EtiquetaController {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @GetMapping("/etiquetas")
    public ResponseEntity<List<Etiqueta>> getAllEtiquetas(){
        List<Etiqueta> etiquetas=etiquetaRepository.findAll();
        return new ResponseEntity<List<Etiqueta>>(etiquetas, HttpStatus.OK);
    }
    @GetMapping("/etiquetas/tags")
    public ResponseEntity<List<String>> getUserMaxId(){
        List<String> tags= etiquetaRepository.listaEtiquetas();
        return new ResponseEntity<List<String>>(tags,HttpStatus.OK);
    }

    @PostMapping("/etiquetas")
    public ResponseEntity<Etiqueta> createEtiqueta( @RequestBody Etiqueta etiqueta){
        Etiqueta newEtiqueta=
                etiquetaRepository.save(
                        new Etiqueta(etiqueta.getName())
                );
        return new ResponseEntity<Etiqueta>(newEtiqueta,HttpStatus.CREATED);
    }

    @PutMapping("/etiquetas/{id}")
    public ResponseEntity<Etiqueta> updateEtiqueta(
            @PathVariable("id") Long id,
            @RequestBody Etiqueta etiqueta){
        Etiqueta etiquetaUpdate= etiquetaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found etiqueta with id="+id));

        etiquetaUpdate.setName(etiqueta.getName());


        return new ResponseEntity<Etiqueta>(etiquetaRepository.save(etiquetaUpdate),
                HttpStatus.OK);
    }

    @DeleteMapping("/etiquetas/{id}")
    public ResponseEntity<HttpStatus> deleteEtiqueta(@PathVariable("id") Long id){
        etiquetaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
