package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Curso;
import pe.edu.estubeca.estubeca.entities.CursoUser;
import pe.edu.estubeca.estubeca.repository.CursoUserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CursoUserController {
    @Autowired
    private CursoUserRepository cursoUserRepository;
    @GetMapping("/cursos/{id1}/users/{id2}")
    public ResponseEntity <CursoUser> getByCursoIdUserId(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){
        CursoUser obj =cursoUserRepository.findAllByCursoUser(id1,id2);
        return new ResponseEntity<CursoUser>(obj, HttpStatus.OK);
    }
    @PostMapping("/cursos-users")
    public ResponseEntity<CursoUser> createSubscripcion(@RequestBody CursoUser cursouser){
        CursoUser newObj = cursoUserRepository.save(
                new CursoUser(cursouser.getCurso(),
                        cursouser.getUser(),
                        cursouser.getProgreso(),
                        cursouser.getSubscrito())
        );
        return new ResponseEntity<CursoUser>(newObj, HttpStatus.CREATED);
    }
}
