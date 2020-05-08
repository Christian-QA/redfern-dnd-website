package com.qa.service;

import com.qa.domain.Skills;
import com.qa.dto.SkillsDTO;
import com.qa.exceptions.SkillNotFoundException;
import com.qa.repo.SkillsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsService {

    private final SkillsRepo repo;

    private final ModelMapper mapper;

    @Autowired
    public SkillsService(SkillsRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private SkillsDTO mapToDTO(Skills skills){
        return this.mapper.map(skills, SkillsDTO.class);
    }


    public List<SkillsDTO> readSkills(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public SkillsDTO createSkills(Skills skills){
        Skills tempSkills = this.repo.save(skills);
        return this.mapToDTO(tempSkills);
    }

    public SkillsDTO findSkillsById(Long id){
        return this.mapToDTO(this.repo.findById(id)
                .orElseThrow(SkillNotFoundException::new));
    }

    public SkillsDTO updateSkills(Long id, Skills skills){
        Skills update = this.repo.findById(id).orElseThrow(SkillNotFoundException::new);
        update.setTitle(skills.getTitle());
        update.setDescription(skills.getDescription());
        Skills tempSkills = this.repo.save(skills);
        return this.mapToDTO(tempSkills);
    }

    public boolean deleteSkills(Long id){
        if(!this.repo.existsById(id)){
            throw new SkillNotFoundException ();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
