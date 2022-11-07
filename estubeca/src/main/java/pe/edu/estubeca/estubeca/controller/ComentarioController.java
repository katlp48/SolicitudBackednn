package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Comentario;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.ComentarioRepository;
import pe.edu.estubeca.estubeca.repository.PostRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ComentarioController {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    //GET=>http:localthost:8080/api/comentarios
    @GetMapping("/comentarios")
    public ResponseEntity<List<Comentario>> getAllComentarios(){
        List<Comentario> comentarios=comentarioRepository.findAll();
        return new ResponseEntity<List<Comentario>>(comentarios,HttpStatus.OK);
    }

    //GET=>http:localthost:8080/api/comentarios/1
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<Comentario> getComentarioById(@PathVariable("id") Long id){
        Comentario comentario= comentarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontró comentario con id="+id));
        return new ResponseEntity<Comentario>(comentario,HttpStatus.OK);
    }

    //doubt**
    @GetMapping("/posts/{id}/comentarios")
    public ResponseEntity<List<Comentario>> getAllComentariosByPostId(@PathVariable("id") Long id){
        List<Comentario> comentarios=comentarioRepository.findAllComentariosPostId(id);
        return new ResponseEntity<List<Comentario>>(comentarios,HttpStatus.OK);
    }

    //POST=>http:localhost:8080/api/comentarios
    @PostMapping("/comentarios")
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario){
        Comentario newComentario=
                comentarioRepository.save(
                        new Comentario(comentario.getBody(),
                                comentario.getAutor(),
                                comentario.getCreatedAt(),
                                comentario.getPost())
                );
        return new ResponseEntity<Comentario>(newComentario,HttpStatus.CREATED);
    }

    //PUT=>http:localhost:8080/api/comentarios/1
    @PutMapping("/comentarios/{id}")
    public ResponseEntity<Comentario> updateComentario(
            @PathVariable("id") Long id,
            @RequestBody Comentario comentario){
        Comentario comentarioUpdate=comentarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontró comentario con id="+id));

        comentarioUpdate.setBody(comentario.getBody());
        comentarioUpdate.setAutor(comentario.getAutor());
        comentarioUpdate.setCreatedAt(comentario.getCreatedAt());
        comentarioUpdate.setPost(comentario.getPost());

        return new ResponseEntity<Comentario>(comentarioRepository.save(comentarioUpdate),HttpStatus.OK);
    }

    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<HttpStatus> deleteComentario(@PathVariable("id") Long id){
        comentarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
