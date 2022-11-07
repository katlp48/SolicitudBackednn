package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Role;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.RoleRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getallRoles(){
        List<Role> roles=roleRepository.findAll();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @GetMapping("/roles/{idRole}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id){
        Role role= roleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found role with id="+id));


        return new ResponseEntity<Role>(role,HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole( @RequestBody Role role){
        Role newRole=
                roleRepository.save(
                        new Role(role.getRoleUser())
                );
        return new ResponseEntity<Role>(newRole,HttpStatus.CREATED);
    }

}
