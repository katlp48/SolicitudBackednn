package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Role;
import pe.edu.estubeca.estubeca.entities.Post;
import pe.edu.estubeca.estubeca.entities.User;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.CursoRepository;
import pe.edu.estubeca.estubeca.repository.ProfileRepository;
import pe.edu.estubeca.estubeca.repository.RoleRepository;
import pe.edu.estubeca.estubeca.repository.UserRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RoleRepository roleRepository;


    //GET=>http:localthost:8080/api/users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //GET=>http:localthost:8080/api/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user with id="+id));


        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @GetMapping("/users/maxId")
    public ResponseEntity<User> getUserMaxId(){
        User userMax= userRepository.getUserMaxId();
        return new ResponseEntity<User>(userMax,HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser=
                userRepository.save(
                        new User(user.getEmail(),
                                user.getPassword(),
                                user.getUsername(),
                                //user.getCursos(),
                                user.getRole())
                );
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }
    //PUT=>http:localthost:8080/api/users/1
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Long id,
            @RequestBody User user){
        User userUpdate= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));

        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setUsername(user.getUsername());

        return new ResponseEntity<User>(userRepository.save(userUpdate),
                HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*@GetMapping("/cursos/asistentes")
    public ResponseEntity<List<String>> ListNumeroUsuariosPorCursoJPQL(){
        List<String> cursos=cursoRepository.ListNumeroUsuarioPorCursoJPQL();
        return new ResponseEntity<List<String>>(cursos, HttpStatus.OK);
    }*/

    @PutMapping("/users/{id}/upgrade")
    public ResponseEntity<User> updatePremium(
            @PathVariable("id") Long id,
            @RequestBody Role premium){
        User userUpdate= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));
        userUpdate.setRole(premium);

        return new ResponseEntity<User>(userRepository.save(userUpdate),
                HttpStatus.OK);
    }
}
