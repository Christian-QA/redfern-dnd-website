package com.qa.service;

import com.qa.domain.Character;
import com.qa.domain.Skills;
import com.qa.dto.CharacterDTO;
import com.qa.exceptions.CharacterNotFoundException;
import com.qa.repo.CharacterRepo;
import com.qa.repo.SkillsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    private final SkillsRepo skillsRepo;

    private final ModelMapper mapper;

    @Autowired
    public CharacterService(CharacterRepo characterRepo, SkillsRepo skillsRepo, ModelMapper mapper) {
        this.characterRepo = characterRepo;
        this.skillsRepo = skillsRepo;
        this.mapper = mapper;
    }

    private CharacterDTO mapToDTO(Character character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    public List<CharacterDTO> readCharacter(){
        return this.characterRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CharacterDTO createCharacter(Character character){
        return this.mapToDTO(this.characterRepo.save(character));
    }

    public CharacterDTO findCharacterById(Long id){
        return this.mapToDTO(this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new));
    }

    public CharacterDTO updateCharacter(Long id, Character character){
        Character update = this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        update.setName(character.getName());
        update.setMaxHp(character.getMaxHp());
        update.setCurrentHp(character.getCurrentHp());
        update.setExp(character.getExp());
        Character tempCharacter = this.characterRepo.save(update);
        return this.mapToDTO(tempCharacter);
    }

    public boolean deleteCharacter(Long id){
        if(!this.characterRepo.existsById(id)){
            throw new CharacterNotFoundException ();
        }
        this.characterRepo.deleteById(id);
        return this.characterRepo.existsById(id);
    }

    public CharacterDTO addSkillsToCharacter(Long id, Skills skills){
        Character character = this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Skills tmp = this.skillsRepo.saveAndFlush(skills);
        character.getSkills ().add(tmp);
        return this.mapToDTO(this.characterRepo.saveAndFlush(character));
    }

}
