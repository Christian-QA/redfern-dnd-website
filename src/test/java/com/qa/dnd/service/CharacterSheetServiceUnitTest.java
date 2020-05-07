package com.qa.dnd.service;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.repo.CharacterSheetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CharacterSheetServiceUnitTest {

    @InjectMocks
    private CharacterSheetService service;

    @Mock
    private CharacterSheetRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<CharacterSheet> characterSheetList;
    private CharacterSheet testCharacterSheet;
    private final long id = 1L;
    private CharacterSheet testCharacterSheetWithID;

    ///private CharacterSheetDTO characterSheetDTO;

    ///private CharacterSheetDTO mapToDTO(CharacterSheet characterSheet){
   ///     return this.mapper.map(note, CharacterSheetDTO.class);
    ///}

    @Before
    public void setUp() {
        this.characterSheetList = new ArrayList<>();
        this.testCharacterSheet = new CharacterSheet();
        this.characterSheetList.add(testCharacterSheet);
        this.testCharacterSheetWithID = new CharacterSheet();
        this.testCharacterSheetWithID.setId(id);
    }

    @Test
    public void getAllCharacterSheetsTest() {
        when(repository.findAll()).thenReturn(this.characterSheetList);
        ///DTO test stuff goes here
        assertFalse("Service returned no character sheets", this.service.readCharacterSheet().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createCharacterSheetTest() {
        when(repository.save(testCharacterSheet)).thenReturn(testCharacterSheetWithID);
        ///when(this.mapper.map(testCharacterSheetWithID, characterSheetDTO.class)).thenReturn(characterSheetDTO);
        ///assertEquals(this.service.createCharacterSheet (testCharacterSheet), this.characterSheetDTO);
        verify(repository, times(1)).save(this.testCharacterSheet);
    }
}
