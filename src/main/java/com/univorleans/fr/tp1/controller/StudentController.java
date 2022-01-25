//package com.univorleans.fr.tp1.controller;
//
//import com.univorleans.fr.tp1.domain.IdentityData;
//import com.univorleans.fr.tp1.domain.Student;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicLong;
//
//@RestController
//@RequestMapping("/pdicost.univ-orleans.fr/.m1ws/enjoy/")
//public class StudentController {
//
//    private static List<Student> students=new ArrayList<>();
//    private static List<IdentityData> identityDatas=new ArrayList<>();
//    private final AtomicLong counter=new AtomicLong(1L);
//
//    @PostMapping("/nouveau-etudiant")
//    public ResponseEntity<Student> createStudent(@RequestBody Student student){
//
//        Student studentRec= new Student(counter.getAndIncrement(),student.getNumeroEtu(),student.getNom(),student.getPrenom());
//        students.add(studentRec);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(studentRec.getId()).toUri();
//
//        return ResponseEntity.created(location).body(studentRec);
//    }
//
//    @PostMapping("/student")
//    public ResponseEntity<IdentityData> createStudent(@RequestBody IdentityData identityData){
//
//        IdentityData identityDataRec=new IdentityData(counter.getAndIncrement(), identityData.getNom(),identityData.getPrenom());
//
//        identityDatas.add(identityDataRec);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(identityDataRec.getId()).toUri();
//
//        return ResponseEntity.created(location).body(identityDataRec);
//
//    }
//
//    @GetMapping("/student/{id}")
//    public ResponseEntity<IdentityData> retrieveIdentityData(@PathVariable("id") Long id){
//        Optional<IdentityData> identityData=this.identityDatas.stream().filter(i -> i.getId()==id).findAny();
//        if(identityData.isPresent()){
//            return ResponseEntity.ok().body(identityData.get());
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @GetMapping("/students")
//    public ResponseEntity<List<IdentityData>> getAll(){return ResponseEntity.ok().body(this.identityDatas);}
//
//    @PutMapping("/{id}/identity")
//    public ResponseEntity<IdentityData> updateIdentityData(
//            @PathVariable("id") long id, @RequestBody IdentityData identityData){
//
//        Optional<IdentityData> identityDataUpdated = identityDatas.stream().filter(i -> i.getId()==id).findAny();
//
//        if(identityDataUpdated.isPresent()){
//            this.identityDatas.remove(id);
//            this.identityDatas.add(identityData);
//            return new ResponseEntity<IdentityData>(identityData, HttpStatus.OK);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
