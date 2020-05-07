package com.qa.dnd.service;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.exceptions.CharacterNotFoundException;
import com.qa.dnd.repo.CharacterSheetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterSheetService {

    private final CharacterSheetRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public CharacterSheetService(CharacterSheetRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private CharacterSheetDTO mapToDTO(CharacterSheet character){
        return this.mapper.map(character, CharacterSheetDTO.class);
    }


    public List<CharacterSheetDTO> readCharacterSheet(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CharacterSheetDTO createCharacterSheet(CharacterSheet character){
        CharacterSheet tempNote = this.repo.save(character);
        return this.mapToDTO(tempNote);
    }

    public CharacterSheetDTO findCharacterSheetById(Long id){
        return this.mapToDTO(this.repo.findById(id)
                .orElseThrow(CharacterNotFoundException::new));
    }

    public CharacterSheetDTO updateCharacterSheet(Long id, CharacterSheet character){
        CharacterSheet update = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        update.setCharacter_name(character.getCharacter_name());
        update.setMax_hp (character.getMax_hp());
        update.setCurrent_hp (character.getCurrent_hp());
        update.setExp (character.getExp());
        CharacterSheet tempNote = this.repo.save(character);
        return this.mapToDTO(tempNote);
    }

    public boolean deleteCharacterSheet(Long id){
        if(!this.repo.existsById(id)){
            throw new CharacterNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
