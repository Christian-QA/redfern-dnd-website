package com.qa.controller;

import com.qa.domain.Abilities;
import com.qa.domain.CharacterSheet;
import com.qa.domain.Skills;
import com.qa.dto.CharacterDTO;
import com.qa.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

@RestController
public class CharacterController {

    private final CharacterService service;

    @Autowired
    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/getAllCharacters")
    public ResponseEntity<Set<CharacterDTO>> getAllCharacters(){
        return ResponseEntity.ok(this.service.readCharacter ());
    }

    @PostMapping("/createCharacter")
    public ResponseEntity<CharacterDTO> createCharacter(@RequestBody CharacterSheet characterSheet){
        return new ResponseEntity<>(this.service.createCharacter (characterSheet), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCharacter/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Long id){
        return this.service.deleteCharacter (id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCharacterById/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCharacterById (id));
    }

    @PutMapping("/updateCharacter/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterSheet characterSheet){
        return ResponseEntity.ok(this.service.updateCharacter (id, characterSheet));
    }

    @PutMapping("/updateCharacter2")
    public ResponseEntity<CharacterDTO> updateCharacter2(@PathParam("id") Long id, @RequestBody CharacterSheet characterSheet){
        return ResponseEntity.ok(this.service.updateCharacter (id, characterSheet));
    }

    @PatchMapping("/addSkillsToCharacter/{id}")
    public ResponseEntity<CharacterDTO> addSkillsToCharacter(@PathVariable Long id, @RequestBody Skills skills){
        return new ResponseEntity<>(this.service.addSkillsToCharacter (id, skills), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/addAbilitiesToCharacter/{id}")
    public ResponseEntity<CharacterDTO> addAbilitiesToCharacter(@PathVariable Long id, @RequestBody Abilities abilities){
        return new ResponseEntity<>(this.service.addAbilitiesToCharacter (id, abilities), HttpStatus.ACCEPTED);
    }

}
