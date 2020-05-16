package com.qa.mesadnd.controller;

import com.qa.mesadnd.domain.Abilities;
import com.qa.mesadnd.dto.AbilitiesDTO;
import com.qa.mesadnd.service.AbilitiesService;
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
@TestPropertySource(locations="classpath:resources/test.properties")
public class AbilitiesControllerUnitTest {

    @InjectMocks
    private AbilitiesController abilitiesController;

    @Mock
    private AbilitiesService service;

    private List<Abilities> abilities;

    private Abilities testAbilities;

    private Abilities testAbilitiesWithId;

    private final long id = 1L;

    private AbilitiesDTO abilitiesDTO;

    private final ModelMapper mapper = new ModelMapper();

    private AbilitiesDTO mapToDTO(Abilities abilities){
        return this.mapper.map(abilities, AbilitiesDTO.class);
    }

    @Before
    public void setUp(){
        this.abilities = new ArrayList<>();
        this.testAbilities = new Abilities (10L, 10L, 10L, 10L, 10L, 10L);
        this.abilities.add(testAbilities);
        this.testAbilitiesWithId = new Abilities (testAbilities.getStrength (), testAbilities.getDexterity (), testAbilities.getConstitution (), testAbilities.getIntelligence (), testAbilities.getWisdom (), testAbilities.getCharisma ());
        this.testAbilitiesWithId.setAbilitiesId (this.id);
        this.abilitiesDTO = this.mapToDTO(testAbilitiesWithId);
    }

    @Test
    public void getAllAbilitiesTest(){
        when(service.readAbilities ()).thenReturn(this.abilities.stream().map(this::mapToDTO).collect(Collectors.toSet ()));
        assertFalse("No abilities found", this.abilitiesController.getAllAbilities ().getBody().isEmpty());
        verify(service, times(1)).readAbilities ();
    }

    @Test
    public void createAbilitiesTest(){
        when(this.service.createAbilities (testAbilities)).thenReturn(this.abilitiesDTO);
        assertEquals(this.abilitiesController.createAbilities (testAbilities), new ResponseEntity<AbilitiesDTO>(this.abilitiesDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createAbilities (testAbilities);
    }

    @Test
    public void deleteAbilitiesTestFalse(){
        this.abilitiesController.deleteAbilities (id);
        verify(service, times(1)).deleteAbilities (id);
    }


    @Test
    public void deleteSkillsTestTrue(){
        when(service.deleteAbilities (3L)).thenReturn(true);
        this.abilitiesController.deleteAbilities (3L);
        verify(service, times(1)).deleteAbilities (3L);
    }

    @Test
    public void getAbilitiesByIDTest(){
        when(this.service.findAbilitiesById (id)).thenReturn(this.abilitiesDTO);
        assertEquals(this.abilitiesController.getAbilitiesById (id), new ResponseEntity<AbilitiesDTO>(this.abilitiesDTO, HttpStatus.OK));
        verify(service, times(1)).findAbilitiesById (id);
    }
}
