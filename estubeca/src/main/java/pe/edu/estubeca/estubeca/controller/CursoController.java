package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Curso;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.CursoRepository;
import pe.edu.estubeca.estubeca.util.CursoExcelExporter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> getAllCursos(){
        List<Curso> cursos=cursoRepository.findAll();
        return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") Long id){
        Curso curso=cursoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Curso with id=" + id));
        return new ResponseEntity<Curso>(curso, HttpStatus.OK);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        Curso newCurso = cursoRepository.save(
                new Curso(curso.getTitle(),
                        curso.getDescription(),
                        curso.getFinished(),
                        curso.getCost())
        );
        return new ResponseEntity<Curso>(newCurso, HttpStatus.CREATED);
    }

       @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> updateCurso(
            @PathVariable("id") Long id,
            @RequestBody Curso curso){
        Curso cursoUpdate= cursoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found cursos with id="+id));

        cursoUpdate.setTitle(curso.getTitle());
        cursoUpdate.setDescription((curso.getDescription()));
        cursoUpdate.setFinished(curso.getFinished());
        cursoUpdate.setCost(curso.getCost());

        return new ResponseEntity<Curso>(cursoRepository.save(cursoUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<HttpStatus> deleteCurso(@PathVariable("id") Long id){
        cursoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/cursos/{nombre}")
    public ResponseEntity<List<String>> ListUsuariosPorCursoJPQL(@PathVariable("nombre")String nombre){
        List<String> cursos=cursoRepository.ListUsuariosPorCursoJPQL(nombre);
        return new ResponseEntity<List<String>>(cursos, HttpStatus.OK);
    }*/
    @GetMapping("/cursos/asistentes")
    public ResponseEntity<List<String>> ListNumeroUsuariosPorCursoJPQL(){
        List<String> cursos=cursoRepository.ListNumeroUsuarioPorCursoJPQL();
        return new ResponseEntity<List<String>>(cursos, HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    @GetMapping("/cursos/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_curso";
        response.setHeader(headerKey, headerValue);

        List<Curso> cursos = cursoRepository.findAll();

        CursoExcelExporter excelExporter = new CursoExcelExporter(
                cursos);

        excelExporter.export(response);


    }
}
