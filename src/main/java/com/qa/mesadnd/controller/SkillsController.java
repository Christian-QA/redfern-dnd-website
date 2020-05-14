package com.qa.mesadnd.controller;

import com.qa.mesadnd.domain.Skills;
import com.qa.mesadnd.dto.SkillsDTO;
import com.qa.mesadnd.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class SkillsController {

    private final SkillsService service;

    @Autowired
    public SkillsController(SkillsService service) {
        this.service = service;
    }

    @GetMapping("/getAllSkills")
    public ResponseEntity<Set<SkillsDTO>> getAllSkills(){
        return ResponseEntity.ok(this.service.readSkills ());
    }

    @PostMapping("/createSkills")
    public ResponseEntity<SkillsDTO> createSkills(@RequestBody Skills skills){
        return new ResponseEntity<>(this.service.createSkills (skills), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSkills/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable Long id){
        return this.service.deleteSkills (id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getSkillsById/{id}")
    public ResponseEntity<SkillsDTO> getSkillsById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findSkillsById (id));
    }

//    @PutMapping("/updateNote/{id}")
//    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody Note note){
//        return ResponseEntity.ok(this.service.updateNote(id, note));
//    }
//
//    @PutMapping("/updateNote2")
//    public ResponseEntity<NoteDTO> updateNote2(@PathParam("id") Long id, @RequestBody Note note){
//        return ResponseEntity.ok(this.service.updateNote(id, note));
//    }

}
