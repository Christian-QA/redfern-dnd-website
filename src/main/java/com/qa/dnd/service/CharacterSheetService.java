package com.qa.dnd.service;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.domain.Skills;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.exceptions.CharacterNotFoundException;
import com.qa.dnd.repo.CharacterSheetRepository;
import com.qa.dnd.repo.SkillsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterSheetService {

    private final CharacterSheetRepository characterSheetRepo;

    private final SkillsRepository skillsRepo;

    private final ModelMapper mapper;

    @Autowired
    public CharacterSheetService(CharacterSheetRepository characterSheetRepo, SkillsRepository skillsRepository, ModelMapper mapper) {
        this.characterSheetRepo = characterSheetRepo;
        this.skillsRepo = skillsRepository;
        this.mapper = mapper;
    }

    private CharacterSheetDTO mapToDTO(CharacterSheet character){
        return this.mapper.map(character, CharacterSheetDTO.class);
    }


    public List<CharacterSheetDTO> readCharacterSheet(){
        return this.characterSheetRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CharacterSheetDTO createCharacterSheet(CharacterSheet character){
        CharacterSheet tempNote = this.characterSheetRepo.save(character);
        return this.mapToDTO(tempNote);
    }

    public CharacterSheetDTO findCharacterSheetById(Long id){
        return this.mapToDTO(this.characterSheetRepo.findById(id)
                .orElseThrow(CharacterNotFoundException::new));
    }

//    public CharacterSheetDTO updateCharacterSheet(Long id, CharacterSheet character){
//        CharacterSheet update = this.characterSheetRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
//        update.setCharacterName (character.getCharacterName ());
//        update.setMaxHp (character.getMaxHp ());
//        update.setCurrentHp (character.getCurrentHp ());
//        update.setExp (character.getExp());
//        CharacterSheet tempNote = this.characterSheetRepo.save(character);
//        return this.mapToDTO(tempNote);
//    }

    public boolean deleteCharacterSheet(Long id){
        if(!this.characterSheetRepo.existsById(id)){
            throw new CharacterNotFoundException();
        }
        this.characterSheetRepo.deleteById(id);
        return this.characterSheetRepo.existsById(id);
    }

    public CharacterSheetDTO addSkillsToCharacterSheet(Long id, Skills skills) {
        CharacterSheet characterSheet = this.characterSheetRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Skills tmp = this.skillsRepo.saveAndFlush(skills);
        characterSheet.getSkills().add(tmp);
        return this.mapToDTO(this.characterSheetRepo.saveAndFlush(characterSheet));
    }

}
