package com.univorleans.fr.tp1.controller;

import com.univorleans.fr.tp1.domain.IdentityData;
import com.univorleans.fr.tp1.domain.Student;
import com.univorleans.fr.tp1.services.StudentRessourceHardcoded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentDatasController {

    @Autowired
    private StudentRessourceHardcoded studentRessourceHardcodedService;


    @GetMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/students")
    public List<IdentityData> getAllDatas(){
        return studentRessourceHardcodedService.findAll();
    }

    @GetMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/student/{id}")
    public IdentityData getData(@PathVariable long id){
        return studentRessourceHardcodedService.findById(id);
    }


    @DeleteMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/students/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){

        IdentityData student = studentRessourceHardcodedService.deleteById(id);

        if(student!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/{id}/identity")
    public ResponseEntity<IdentityData> updateIdentityData(@PathVariable long id, @RequestBody IdentityData identityData){

        IdentityData studentUpdated = studentRessourceHardcodedService.save(identityData);

        return new ResponseEntity<IdentityData>(identityData, HttpStatus.OK);
    }

    @PostMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/student")
    public ResponseEntity<Void> createIdentityData(@RequestBody IdentityData identityData){

        IdentityData createdIdentityData = studentRessourceHardcodedService.save(identityData);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdIdentityData.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
