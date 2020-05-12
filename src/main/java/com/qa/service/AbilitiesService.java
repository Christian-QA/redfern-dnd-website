package com.qa.service;

import com.qa.domain.Abilities;
import com.qa.dto.AbilitiesDTO;
import com.qa.exceptions.AbilityNotFoundException;
import com.qa.repo.AbilitiesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbilitiesService {

    private final AbilitiesRepo repo;

    private final ModelMapper mapper;

    @Autowired
    public AbilitiesService(AbilitiesRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private AbilitiesDTO mapToDTO(Abilities abilities){
        return this.mapper.map(abilities, AbilitiesDTO.class);
    }


    public List<AbilitiesDTO> readSkills(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public AbilitiesDTO createAbilities(Abilities abilities){
        Abilities tempAbilities = this.repo.save(abilities);
        return this.mapToDTO(tempAbilities);
    }

    public AbilitiesDTO findAbilitiesById(Long id){
        return this.mapToDTO(this.repo.findById(id)
                .orElseThrow(AbilityNotFoundException::new));
    }

    public AbilitiesDTO updateAbilities(Long id, Abilities abilities){
        Abilities update = this.repo.findById(id).orElseThrow(AbilityNotFoundException::new);
        update.setStrength (abilities.getStrength ());
        update.setDexterity (abilities.getDexterity ());
        update.setConstitution (abilities.getConstitution ());
        update.setIntelligence (abilities.getIntelligence ());
        update.setWisdom (abilities.getWisdom ());
        update.setCharisma (abilities.getCharisma ());
        Abilities tempAbilities = this.repo.save(abilities);
        return this.mapToDTO(tempAbilities);
    }

    public boolean deleteAbilities(Long id){
        if(!this.repo.existsById(id)){
            throw new AbilityNotFoundException ();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
