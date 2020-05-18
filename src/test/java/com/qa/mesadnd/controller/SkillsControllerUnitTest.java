package com.qa.mesadnd.controller;

import com.qa.mesadnd.domain.Skills;
import com.qa.mesadnd.dto.SkillsDTO;
import com.qa.mesadnd.service.SkillsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(locations= "classpath:test.properties")
public class SkillsControllerUnitTest {

    @InjectMocks
    private SkillsController skillsController;

    @Mock
    private SkillsService service;

    private List<Skills> skills;

    private Skills testSkills;

    private Skills testSkillsWithId;

    private final long id = 1L;

    private SkillsDTO skillsDTO;

    private final ModelMapper mapper = new ModelMapper();

    private SkillsDTO mapToDTO(Skills skills){
        return this.mapper.map(skills, SkillsDTO.class);
    }

    @Before
    public void setUp(){
        this.skills = new ArrayList<>();
        this.testSkills = new Skills ("Arcana", "Intelligence");
        this.skills.add(testSkills);
        this.testSkillsWithId = new Skills (testSkills.getSkillName (), testSkills.getStatModifier());
        this.testSkillsWithId.setSkillsId (this.id);
        this.skillsDTO = this.mapToDTO(testSkillsWithId);
    }

    @Test
    public void getAllSkillsTest(){
        when(service.readSkills ()).thenReturn(this.skills.stream().map(this::mapToDTO).collect(Collectors.toSet()));
        assertFalse("No skills found", this.skillsController.getAllSkills ().getBody().isEmpty());
        verify(service, times(1)).readSkills ();
    }

    @Test
    public void createSkillsTest(){
        when(this.service.createSkills (testSkills)).thenReturn(this.skillsDTO);
        assertEquals(this.skillsController.createSkills (testSkills), new ResponseEntity<SkillsDTO>(this.skillsDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createSkills (testSkills);
    }

    @Test
    public void deleteSkillsTestFalse(){
        this.skillsController.deleteSkills (id);
        verify(service, times(1)).deleteSkills (id);
    }


    @Test
    public void deleteSkillsTestTrue(){
        when(service.deleteSkills (3L)).thenReturn(true);
        this.skillsController.deleteSkills (3L);
        verify(service, times(1)).deleteSkills (3L);
    }

    @Test
    public void getSkillsByIDTest(){
        when(this.service.findSkillsById (id)).thenReturn(this.skillsDTO);
        assertEquals(this.skillsController.getSkillsById (id), new ResponseEntity<SkillsDTO>(this.skillsDTO, HttpStatus.OK));
        verify(service, times(1)).findSkillsById (id);
    }
}
