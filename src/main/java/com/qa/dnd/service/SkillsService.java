package com.qa.dnd.service;

import com.qa.dnd.domain.Skills;
import com.qa.dnd.dto.SkillsDTO;
import com.qa.dnd.exceptions.SkillsNotFoundException;
import com.qa.dnd.repo.SkillsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsService {

    private final SkillsRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public SkillsService(SkillsRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private SkillsDTO mapToDTO(Skills skills) {
        return this.mapper.map(skills, SkillsDTO.class);
    }

    public List<SkillsDTO> readSkills() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public SkillsDTO createSkills(Skills skills) {
        Skills tempSkill = this.repo.save(skills);
        return this.mapToDTO(tempSkill);
    }

    public SkillsDTO findSkillsById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow (SkillsNotFoundException::new));
    }

    public SkillsDTO updateSkills(Long id, Skills skills) {
        Skills update = this.repo.findById(id).orElseThrow(SkillsNotFoundException::new);
        update.setSkillName(skills.getSkillName());
        Skills tempSkill = this.repo.save(skills);
        return this.mapToDTO(tempSkill);
    }

    public boolean deleteSkills(Long id) {
        if (!this.repo.existsById(id)) {
            throw new SkillsNotFoundException ();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
