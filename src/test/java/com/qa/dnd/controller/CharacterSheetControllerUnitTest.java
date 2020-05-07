package com.qa.dnd.controller;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.service.CharacterSheetService;
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
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CharacterSheetControllerUnitTest {

    @InjectMocks
    private CharacterSheetController characterSheetController;

    @Mock
    private CharacterSheetService service;
    private List<CharacterSheet> characterSheets;
    private CharacterSheet testCharacterSheet;
    private CharacterSheet testCharacterWithID;
    private final long id = 1L;
    private CharacterSheetDTO characterSheetDTO;
    private final ModelMapper mapper = new ModelMapper();

    private CharacterSheetDTO mapToDTO(CharacterSheet characterSheet) {
        return this.mapper.map(characterSheet, CharacterSheetDTO.class);
    }

    @Before
    public void setUp() {
        this.characterSheets = new ArrayList<>();
        this.testCharacterSheet = new CharacterSheet("Corvus", 14L, 14L, 3000L);
        this.characterSheets.add(testCharacterSheet);
        this.testCharacterWithID = new CharacterSheet(testCharacterSheet.getCharacterName (), testCharacterSheet.getMaxHp (), testCharacterSheet.getCurrentHp (), testCharacterSheet.getExp());
        this.testCharacterWithID.setId(this.id);
        this.characterSheetDTO = this.mapToDTO(testCharacterWithID);
    }

    @Test
    public void getAllCharacterSheetTest() {
        when(service.readCharacterSheet ()).thenReturn(this.characterSheets.stream().map(this::mapToDTO).collect(Collectors.toList ()));
        assertFalse("No character sheets found", Objects.requireNonNull (this.characterSheetController.getAllCharacterSheet ().getBody ()).isEmpty());
        verify (service, times(1)).readCharacterSheet();
    }

    @Test
    public void createCharacterSheetTest(){
        when(this.service.createCharacterSheet(testCharacterSheet)).thenReturn(this.characterSheetDTO);
        assertEquals(this.characterSheetController.createCharacterSheet(testCharacterSheet), new ResponseEntity<CharacterSheetDTO> (this.characterSheetDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createCharacterSheet(testCharacterSheet);
    }

    @Test
    public void deleteCharacterSheetTestFalse(){
        this.characterSheetController.deleteCharacterSheet(id);
        verify(service, times(1)).deleteCharacterSheet(id);
    }

    @Test
    public void deleteCharacterSheetTestTrue(){
        when(service.deleteCharacterSheet(3L)).thenReturn(true);
        this.characterSheetController.deleteCharacterSheet(3L);
        verify(service, times(1)).deleteCharacterSheet(3L);
    }

    @Test
    public void getCharacterSheetByIDTest(){
        when(this.service.findCharacterSheetById(id)).thenReturn(this.characterSheetDTO);
        assertEquals(this.characterSheetController.getCharacterSheetById(id), new ResponseEntity<CharacterSheetDTO>(this.characterSheetDTO, HttpStatus.OK));
        verify(service, times(1)).findCharacterSheetById(id);
    }

}
