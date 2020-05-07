package com.qa.dnd.controller;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.service.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterSheetController {

    private final CharacterSheetService service;

    @Autowired
    public CharacterSheetController(CharacterSheetService service) {
        this.service = service;
    }

    @GetMapping("/getAllCharacterSheets")
    public ResponseEntity<List<CharacterSheetDTO>> getAllCharacterSheet(){
        return ResponseEntity.ok(this.service.readCharacterSheet());
    }

    @PostMapping("/createCharacterSheet")
    public ResponseEntity<CharacterSheetDTO> createCharacterSheet(@RequestBody CharacterSheet character){
        return new ResponseEntity<CharacterSheetDTO>(this.service.createCharacterSheet(character), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCharacterSheet/{id}")
    public ResponseEntity<?> deleteCharacterSheet(@PathVariable Long id){
        return this.service.deleteCharacterSheet(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCharacterSheetById/{id}")
    public ResponseEntity<CharacterSheetDTO> getCharacterSheetById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCharacterSheetById(id));
    }

//    @PutMapping("/updateCharacterSheet/{id}")
//    public CharacterSheet updateCharacterSheet(@PathVariable Long id, @RequestBody CharacterSheet character){
//        return this.service.updateCharacterSheet(id, character);
//    }
//
//    @PutMapping("/updateCharacterSheet2")
//    public CharacterSheet updateCharacterSheet2(@PathParam("id") Long id, @RequestBody CharacterSheet character){
//        return this.service.updateCharacterSheet(id, character);
//    }
}
