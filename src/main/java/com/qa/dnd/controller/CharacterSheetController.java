package com.qa.dnd.controller;

import com.qa.dnd.service.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterSheetController {

    private final CharacterSheetService service;

    @Autowired
    public CharacterSheetController(CharacterSheetService service) {
        this.service = service;
    }


}
