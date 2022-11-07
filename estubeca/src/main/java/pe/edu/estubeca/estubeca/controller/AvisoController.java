package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Aviso;
import pe.edu.estubeca.estubeca.entities.Beca;
import pe.edu.estubeca.estubeca.entities.Comentario;
import pe.edu.estubeca.estubeca.repository.AvisoRepository;
import pe.edu.estubeca.estubeca.repository.ComentarioRepository;
import pe.edu.estubeca.estubeca.repository.PostRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AvisoController {
    @Autowired
    private AvisoRepository avisoRepository;

    //GET=>http:localthost:8080/api/avisos
    @GetMapping("/avisos")
    public ResponseEntity<List<Aviso>> getAllAvisos(){
        List<Aviso> avisos= avisoRepository.findAll();
        return new ResponseEntity<List<Aviso>>(avisos, HttpStatus.OK);
    }

    @PostMapping("/avisos")
    public ResponseEntity<Aviso> createAviso(@RequestBody Aviso aviso){
        Aviso newAviso=
                avisoRepository.save(
                        new Aviso(aviso.getTitle(),
                                aviso.getType(),
                                aviso.getDescription())
                );
        return new ResponseEntity<Aviso>(newAviso,HttpStatus.CREATED);
    }

}
