package com.qa.dnd.controller;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.service.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CharacterSheetController {

    private final CharacterSheetService service;

    @Autowired
    public CharacterSheetController(CharacterSheetService service) {
        this.service = service;
    }

    @GetMapping("/getAllCharacters")
    public List<CharacterSheet> getAllCharacters(){
        return this.service.readCharacterSheet();
    }

    @PostMapping("/createCharacter")
    public CharacterSheet createCharacterSheet(@RequestBody CharacterSheet character){
        return this.service.createCharacterSheet(character);
    }

    @DeleteMapping("/deleteCharacter/{id}")
    public boolean deleteCharacterSheet(@PathVariable Long id){
        return this.service.deleteCharacterSheet(id);
    }

    @GetMapping("/getCharacterById/{id}")
    public CharacterSheet getCharacterSheetById(@PathVariable Long id){
        return this.service.findCharacterSheetById(id);
    }

    @PutMapping("/updateCharacter/{id}")
    public CharacterSheet updateCharacterSheet(@PathVariable Long id, @RequestBody CharacterSheet character){
        return this.service.updateCharacterSheet(id, character);
    }

    @PutMapping("/updateCharacter2")
    public CharacterSheet updateCharacterSheet2(@PathParam("id") Long id, @RequestBody CharacterSheet character){
        return this.service.updateCharacterSheet(id, character);
    }
}
