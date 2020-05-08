package com.qa.service;

import com.qa.domain.Character;
import com.qa.dto.CharacterDTO;
import com.qa.repo.CharacterRepo;
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
public class CharacterServiceUnitTest {

    @InjectMocks
    private CharacterService service;

    @Mock
    private CharacterRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Character> characterList;

    private Character testCharacter;

    private final long id = 1L;

    private Character testCharacterWithID;

    private CharacterDTO characterDTO;

    private CharacterDTO mapToDTO(Character character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.characterList = new ArrayList<> ();
        this.testCharacter = new Character ("Sinnis", 21L, 21L, 3000L);
        this.characterList.add(testCharacter);
        this.testCharacterWithID = new Character (testCharacter.getName(), testCharacter.getMaxHp(), testCharacter.getCurrentHp(), testCharacter.getExp());
        this.testCharacterWithID.setId(id);
        this.characterDTO = this.mapToDTO(testCharacterWithID);
    }

    @Test
    public void getAllCharacterTest(){
        when(repository.findAll()).thenReturn(this.characterList);
        when(this.mapper.map(testCharacterWithID, CharacterDTO.class)).thenReturn(characterDTO);
        assertFalse("Service returned no Notes", this.service.readCharacter().isEmpty());
        verify(repository, times(1)).findAll();
    }
}
