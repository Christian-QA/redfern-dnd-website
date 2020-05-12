package com.qa.controller;

import com.qa.domain.Abilities;
import com.qa.domain.Skills;
import com.qa.dto.AbilitiesDTO;
import com.qa.dto.SkillsDTO;
import com.qa.service.AbilitiesService;
import com.qa.service.SkillsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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
        when(service.readAbilities ()).thenReturn(this.abilities.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No abilities found", this.abilitiesController.getAllAbilities ().getBody().isEmpty());
        verify(service, times(1)).readAbilities ();
    }


}
