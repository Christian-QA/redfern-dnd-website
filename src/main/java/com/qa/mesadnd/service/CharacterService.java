package com.qa.mesadnd.service;

import com.qa.mesadnd.domain.Abilities;
import com.qa.mesadnd.domain.CharacterSheet;
import com.qa.mesadnd.domain.Skills;
import com.qa.mesadnd.dto.CharacterDTO;
import com.qa.mesadnd.exceptions.CharacterNotFoundException;
import com.qa.mesadnd.repo.AbilitiesRepo;
import com.qa.mesadnd.repo.CharacterRepo;
import com.qa.mesadnd.repo.SkillsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    private final SkillsRepo skillsRepo;

    private final AbilitiesRepo abilitiesRepo;

    private final ModelMapper mapper;

    @Autowired
    public CharacterService(CharacterRepo characterRepo, SkillsRepo skillsRepo, AbilitiesRepo abilitiesRepo, ModelMapper mapper) {
        this.characterRepo = characterRepo;
        this.skillsRepo = skillsRepo;
        this.abilitiesRepo = abilitiesRepo;
        this.mapper = mapper;
    }

    private CharacterDTO mapToDTO(CharacterSheet characterSheet){
        return this.mapper.map(characterSheet, CharacterDTO.class);
    }

    public List<CharacterDTO> readCharacter(){
        return this.characterRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CharacterDTO createCharacter(CharacterSheet characterSheet){
        return this.mapToDTO(this.characterRepo.save(characterSheet));
    }

    public CharacterDTO findCharacterById(Long id){
        return this.mapToDTO(this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new));
    }

    public CharacterDTO updateCharacter(Long id, CharacterSheet characterSheet){
        CharacterSheet update = this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        update.setName(characterSheet.getName());
        update.setMaxHp(characterSheet.getMaxHp());
        update.setCurrentHp(characterSheet.getCurrentHp());
        update.setExp(characterSheet.getExp());
        CharacterSheet tempCharacterSheet = this.characterRepo.save(update);
        return this.mapToDTO(tempCharacterSheet);
    }

    public boolean deleteCharacter(Long id){
        if(!this.characterRepo.existsById(id)){
            throw new CharacterNotFoundException ();
        }
        this.characterRepo.deleteById(id);
        return this.characterRepo.existsById(id);
    }

    public CharacterDTO addSkillsToCharacter(Long id, Skills skills){
        CharacterSheet characterSheet = this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Skills tmp = this.skillsRepo.saveAndFlush(skills);
        characterSheet.getSkills ().add(tmp);
        return this.mapToDTO(this.characterRepo.saveAndFlush(characterSheet));
    }

    public CharacterDTO addAbilitiesToCharacter(Long id, Abilities abilities){
        CharacterSheet characterSheet = this.characterRepo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Abilities tmp = this.abilitiesRepo.saveAndFlush(abilities);
        characterSheet.getAbilities ().add(tmp);
        return this.mapToDTO(this.characterRepo.saveAndFlush(characterSheet));
    }

}
