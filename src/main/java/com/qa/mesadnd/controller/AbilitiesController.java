package com.qa.mesadnd.controller;

import com.qa.mesadnd.domain.Abilities;
import com.qa.mesadnd.domain.CharacterSheet;
import com.qa.mesadnd.dto.AbilitiesDTO;
import com.qa.mesadnd.dto.CharacterDTO;
import com.qa.mesadnd.service.AbilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class AbilitiesController {

    private final AbilitiesService service;

    @Autowired
    public AbilitiesController(AbilitiesService service) {
        this.service = service;
    }

    @GetMapping("/getAllAbilities")
    public ResponseEntity<Set<AbilitiesDTO>> getAllAbilities(){
        return ResponseEntity.ok(this.service.readAbilities ());
    }

    @PostMapping("/createAbilities")
    public ResponseEntity<AbilitiesDTO> createAbilities(@RequestBody Abilities abilities){
        return new ResponseEntity<>(this.service.createAbilities (abilities), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAbilities/{id}")
    public ResponseEntity<?> deleteAbilities(@PathVariable Long id){
        return this.service.deleteAbilities (id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getAbilitiesById/{id}")
    public ResponseEntity<AbilitiesDTO> getAbilitiesById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findAbilitiesById (id));
    }

    @PutMapping("/updateAbilities/{id}")
    public ResponseEntity<AbilitiesDTO> updateCharacter(@PathVariable Long id, @RequestBody Abilities abilities){
        return ResponseEntity.ok(this.service.updateAbilities (id, abilities));
    }
}
