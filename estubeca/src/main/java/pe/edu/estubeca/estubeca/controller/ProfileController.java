package pe.edu.estubeca.estubeca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Profile;
import pe.edu.estubeca.estubeca.entities.User;
import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.ProfileRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAllProfiles(){
        List<Profile> profiles=profileRepository.findAll();
        return new ResponseEntity<List<Profile>>(profiles, HttpStatus.OK);
    }
    //GET=>http:localthost:8080/api/profile/1
    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id){
        Profile profile= profileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found profile with id="+id));

        return new ResponseEntity<Profile>(profile,HttpStatus.OK);
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        Profile newProfile=
                profileRepository.save(
                        new Profile(
                                profile.getId(),
                                profile.getUser(),
                                profile.getName(),
                                profile.getLastName(),
                                profile.getPhone(),
                                profile.getImgUrl(),
                                profile.getGrade()
                               )
                );
        return new ResponseEntity<Profile>(newProfile,HttpStatus.CREATED);
    }
    //PUT=>http:localthost:8080/api/profiles/1
    @PutMapping("/profiles/{id}")
    public ResponseEntity<Profile> updateProfile(
            @PathVariable("id") Long id,
            @RequestBody Profile profile){
        Profile profileUpdate= profileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));

       profileUpdate.setName(profile.getName());
       profileUpdate.setLastName(profile.getLastName());
       profileUpdate.setPhone(profile.getPhone());
       profileUpdate.setGrade(profile.getGrade());
       profileUpdate.setImgUrl(profile.getImgUrl());

        return new ResponseEntity<Profile>(profileRepository.save(profileUpdate),
                HttpStatus.OK);
    }

}
