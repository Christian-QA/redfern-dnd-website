package com.qa.controller;

import com.qa.domain.Character;
import com.qa.dto.CharacterDTO;
import com.qa.service.CharacterService;
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
public class CharacterControllerUnitTest {

    @InjectMocks
    private CharacterController characterController;

    @Mock
    private CharacterService service;

    private List<Character> character;

    private Character testCharacter;

    private Character testCharacterWithId;

    private final long id = 1L;

    private CharacterDTO characterDTO;

    private final ModelMapper mapper = new ModelMapper();

    private CharacterDTO mapToDTO(Character character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.character = new ArrayList<> ();
        this.testCharacter = new Character ("Sinnis", 21L, 21L, 3000L);
        this.character.add(testCharacter);
        this.testCharacterWithId = new Character (testCharacter.getName(), testCharacter.getMaxHp(), testCharacter.getCurrentHp(), testCharacter.getExp());
        this.testCharacterWithId.setId(this.id);
        this.characterDTO = this.mapToDTO(testCharacterWithId);
    }

    @Test
    public void getAllCharacterTest(){
        when(service.readCharacter ()).thenReturn(this.character.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No notes found", this.characterController.getAllCharacters().getBody().isEmpty());
        verify(service, times(1)).readCharacter ();
    }

    @Test
    public void createCharacterTest(){
        when(this.service.createCharacter(testCharacter)).thenReturn(this.characterDTO);
        assertEquals(this.characterController.createCharacter(testCharacter), new ResponseEntity<CharacterDTO> (this.characterDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createCharacter(testCharacter);
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
