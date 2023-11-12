package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Beca;
import pe.edu.estubeca.estubeca.entities.Solicitud;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.SolicitudRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SolicitudController {
    @Autowired
    private SolicitudRepository sr;

    @GetMapping("/solicitudes")
    public ResponseEntity<List<Solicitud>> getAllSolicitudes(){
        List<Solicitud> solicitudes=sr.findAll();
        return new ResponseEntity<List<Solicitud>>(solicitudes, HttpStatus.OK);
    }

    @GetMapping("/solicitudes/{id}")
    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable("id") Long id){
        Solicitud solicitud= sr.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found solicitud with id="+id));
        return new ResponseEntity<Solicitud>(solicitud,HttpStatus.OK);
    }
    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> createSolicitud( @RequestBody Solicitud solicitud){
        Solicitud newSolicitud=
                sr.save(
                        new Solicitud(
                                solicitud.getUser(),
                                solicitud.getTipomoneda(),
                                solicitud.getV(),
                                solicitud.getCi(),
                                solicitud.getCf(),
                                solicitud.getFrecuencia(),
                                solicitud.getFechaci(),
                                solicitud.getTipotasa(),
                                solicitud.getPeriodotasa(),
                                solicitud.getValortasa(),
                                solicitud.getCapitalizacion(),
                                solicitud.getPlazo(),
                                solicitud.getPeriodogracia(),
                                solicitud.getCantperiodo(),
                                solicitud.getTasaefectiva())
                );
        return new ResponseEntity<Solicitud>(newSolicitud,HttpStatus.CREATED);
    }
}
