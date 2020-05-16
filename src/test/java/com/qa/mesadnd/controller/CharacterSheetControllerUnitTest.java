package com.qa.mesadnd.controller;

import com.qa.mesadnd.domain.CharacterSheet;
import com.qa.mesadnd.dto.CharacterDTO;
import com.qa.mesadnd.service.CharacterService;
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
public class CharacterSheetControllerUnitTest {

    @InjectMocks
    private CharacterController characterController;

    @Mock
    private CharacterService service;

    private List<CharacterSheet> characterSheet;

    private CharacterSheet testCharacterSheet;

    private CharacterSheet testCharacterSheetWithId;

    private final long id = 1L;

    private CharacterDTO characterDTO;

    private final ModelMapper mapper = new ModelMapper();

    private CharacterDTO mapToDTO(CharacterSheet characterSheet){
        return this.mapper.map(characterSheet, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.characterSheet = new ArrayList<> ();
        this.testCharacterSheet = new CharacterSheet ("Sinnis", 21L, 21L, 3000L);
        this.characterSheet.add(testCharacterSheet);
        this.testCharacterSheetWithId = new CharacterSheet (testCharacterSheet.getName(), testCharacterSheet.getMaxHp(), testCharacterSheet.getCurrentHp(), testCharacterSheet.getExp());
        this.testCharacterSheetWithId.setCharacterId (this.id);
        this.characterDTO = this.mapToDTO(testCharacterSheetWithId);
    }

    @Test
    public void getAllCharacterTest(){
        when(service.readCharacter ()).thenReturn(this.characterSheet.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No notes found", this.characterController.getAllCharacters().getBody().isEmpty());
        verify(service, times(1)).readCharacter ();
    }

    @Test
    public void createCharacterTest(){
        when(this.service.createCharacter(testCharacterSheet)).thenReturn(this.characterDTO);
        assertEquals(this.characterController.createCharacter(testCharacterSheet), new ResponseEntity<CharacterDTO> (this.characterDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createCharacter(testCharacterSheet);
    }

    @Test
    public void deleteCharacterTestFalse(){
        this.characterController.deleteCharacter(id);
        verify(service, times(1)).deleteCharacter(id);
    }

    @Test
    public void getCharacterByIDTest(){
        when(this.service.findCharacterById (id)).thenReturn(this.characterDTO);
        assertEquals(this.characterController.getCharacterById (id), new ResponseEntity<CharacterDTO>(this.characterDTO, HttpStatus.OK));
        verify(service, times(1)).findCharacterById (id);
    }
}
