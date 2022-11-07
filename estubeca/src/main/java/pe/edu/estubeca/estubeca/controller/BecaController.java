package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Beca;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;;
import pe.edu.estubeca.estubeca.repository.BecaRepository;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BecaController {
    @Autowired
    private BecaRepository becaRepository;


    @GetMapping("/becas")
    public ResponseEntity<List<Beca>> getAllBecas(){
        List<Beca> becas=becaRepository.findAll();
        return new ResponseEntity<List<Beca>>(becas,HttpStatus.OK);
    }
    @GetMapping("/becas/{id}")
    public ResponseEntity<Beca> getBecaById(@PathVariable("id") Long id){
        Beca beca= becaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found beca with id="+id));


        return new ResponseEntity<Beca>(beca,HttpStatus.OK);
    }
    @PostMapping("/becas")
    public ResponseEntity<Beca> createBeca( @RequestBody Beca beca){
        Beca newBeca=
                becaRepository.save(
                        new Beca(beca.getTitle(),
                                beca.getImgUrl(),
                                beca.getDescription(),
                                beca.getRequisitos(),
                                beca.getTelefono(),
                                beca.getUrlPage(),
                                beca.getBeneficios(),
                                beca.getTagList())
                );
        return new ResponseEntity<Beca>(newBeca,HttpStatus.CREATED);
    }
    @PutMapping("/becas/{id}")
    public ResponseEntity<Beca> updateBeca(
            @PathVariable("id") Long id,
            @RequestBody Beca beca){
        Beca becaUpdate= becaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found beca with id="+id));

        becaUpdate.setTitle(beca.getTitle());
        becaUpdate.setDescription(beca.getDescription());
        becaUpdate.setBeneficios(beca.getBeneficios());
        becaUpdate.setImgUrl(beca.getImgUrl());
        becaUpdate.setTelefono(beca.getTelefono());
        becaUpdate.setUrlPage(beca.getUrlPage());
        becaUpdate.setRequisitos(beca.getRequisitos());


        return new ResponseEntity<Beca>(becaRepository.save(becaUpdate),
                HttpStatus.OK);
    }
    @DeleteMapping("/becas/{id}")
    public ResponseEntity<HttpStatus> deleteBeca(@PathVariable("id") Long id){
        becaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/becas/filter/{title}")
    public ResponseEntity<List<Beca>> searchByTitle(@PathVariable String title){
        List<Beca> becas=new ArrayList<>();
        List<Beca> becasAux=new ArrayList<>();

        becasAux=becaRepository.findBecaByTitleContainingIgnoreCase(title);

        if(becasAux.size()>0){
            becasAux.stream().forEach((b)->{
                becas.add(b);
            });
        }

        return new ResponseEntity<List<Beca>>(becas, HttpStatus.OK);
    }
}
