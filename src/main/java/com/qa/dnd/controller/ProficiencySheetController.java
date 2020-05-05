package com.qa.dnd.controller;

import com.qa.dnd.domain.ProficiencySheet;
import com.qa.dnd.service.ProficiencySheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProficiencySheetController {

    private final ProficiencySheetService service;

    @Autowired
    public ProficiencySheetController(ProficiencySheetService service) {
        this.service = service;
    }

    @GetMapping("/getAllProficiencySheets")
    public List<ProficiencySheet> getAllProficiencySheet(){
        return this.service.readProficiencySheet();
    }

    @PostMapping("/createProficiencySheet")
    public ProficiencySheet createProficiencySheet(@RequestBody ProficiencySheet character){
        return this.service.createProficiencySheet(character);
    }

    @DeleteMapping("/deleteProficiencySheet/{id}")
    public boolean deleteProficiencySheet(@PathVariable Long id){
        return this.service.deleteProficiencySheet(id);
    }

    @GetMapping("/getProficiencySheetById/{id}")
    public ProficiencySheet getProficiencySheetById(@PathVariable Long id){
        return this.service.findProficiencySheetById(id);
    }

    @PutMapping("/updateProficiencySheet/{id}")
    public ProficiencySheet updateProficiencySheet(@PathVariable Long id, @RequestBody ProficiencySheet character){
        return this.service.updateProficiencySheet(id, character);
    }

    @PutMapping("/updateProficiencySheet2")
    public ProficiencySheet updateProficiencySheet2(@PathParam("id") Long id, @RequestBody ProficiencySheet character){
        return this.service.updateProficiencySheet(id, character);
    }
}
