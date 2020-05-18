package com.qa.mesadnd.service;

import com.qa.mesadnd.domain.Abilities;
import com.qa.mesadnd.dto.AbilitiesDTO;
import com.qa.mesadnd.exceptions.AbilityNotFoundException;
import com.qa.mesadnd.repo.AbilitiesRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations= "classpath:test.properties")
public class AbilitiesServiceUnitTest {

    @InjectMocks
    private AbilitiesService service;

    @Mock
    private AbilitiesRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Abilities> abilitiesList;

    private Abilities testAbilities;

    private final long id = 1L;

    private Abilities testAbilitiesWithID;

    private AbilitiesDTO abilitiesDTO;

    private AbilitiesDTO mapToDTO(Abilities abilities){
        return this.mapper.map(abilities, AbilitiesDTO.class);
    }

    @Before
    public void setUp(){
        this.abilitiesList = new ArrayList<>();
        this.testAbilities = new Abilities (10L, 10L, 10L, 10L, 10L, 10L);
        this.abilitiesList.add(testAbilities);
        this.testAbilitiesWithID = new Abilities (testAbilities.getStrength (), testAbilities.getDexterity (), testAbilities.getConstitution (), testAbilities.getIntelligence (), testAbilities.getWisdom (), testAbilities.getCharisma ());
        this.testAbilitiesWithID.setAbilitiesId (id);
        this.abilitiesDTO = this.mapToDTO(testAbilitiesWithID);
    }

    @Test
    public void getAllAbilitiesTest(){
        when(repository.findAll()).thenReturn(this.abilitiesList);
        when(this.mapper.map(testAbilitiesWithID, AbilitiesDTO.class)).thenReturn(abilitiesDTO);
        assertFalse("Service returned no abilities", this.service.readAbilities ().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createAbilitiesTest(){
        when(repository.save(testAbilities)).thenReturn(testAbilitiesWithID);
        when(this.mapper.map(testAbilitiesWithID, AbilitiesDTO.class)).thenReturn(abilitiesDTO);
        assertEquals(this.service.createAbilities (testAbilities), this.abilitiesDTO);
        verify(repository, times(1)).save(this.testAbilities);
    }

    @Test
    public void findAbilitiesByIdTest(){
        when(this.repository.findById(id)).thenReturn(java.util.Optional.ofNullable(testAbilitiesWithID));
        when(this.mapper.map(testAbilitiesWithID, AbilitiesDTO.class)).thenReturn(abilitiesDTO);
        assertEquals(this.service.findAbilitiesById (this.id), abilitiesDTO);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void deleteAbilitiesByExistingId(){
        when(this.repository.existsById(id)).thenReturn(true, false);
        assertFalse(service.deleteAbilities (id));
        verify(repository, times(1)).deleteById(id);
        verify(repository, times(2)).existsById(id);
    }

    @Test(expected = AbilityNotFoundException.class)
    public void deleteAbilitiesByNonExistingId(){
        when(this.repository.existsById(id)).thenReturn(false);
        service.deleteAbilities (id);
        verify(repository, times(1)).existsById(id);
    }



}
