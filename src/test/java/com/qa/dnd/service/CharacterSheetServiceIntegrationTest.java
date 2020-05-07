package com.qa.dnd.service;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.repo.CharacterSheetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterSheetServiceIntegrationTest {

    @Autowired
    private CharacterSheetService service;

    @Autowired
    private CharacterSheetRepository repo;

    @Autowired
    private ModelMapper mapper;

    private CharacterSheet testCharacterSheet;
    private CharacterSheet testCharacterSheetWithID;

    private CharacterSheetDTO mapToDTO(CharacterSheet characterSheet) {
        return this.mapper.map(characterSheet, CharacterSheetDTO.class);
    }

    @Before
    public void setUp() {
        this.testCharacterSheet = new CharacterSheet("Sinnis Dietritchson", 21L, 21L, 2000L);
        this.repo.deleteAll();
        this.testCharacterSheetWithID = this.repo.save(this.testCharacterSheet);
    }

    @Test
    public void readCharacterSheetTest() {
        assertThat(this.service.readCharacterSheet())
                .isEqualTo(Stream.of(this.mapToDTO (testCharacterSheetWithID)).collect(Collectors.toList()));
    }

    @Test
    public void createCharacterSheetTest(){
        assertEquals(this.mapToDTO(this.testCharacterSheetWithID), this.service.createCharacterSheet(testCharacterSheet));
    }

    @Test
    public void findCharacterSheetByIdTest(){
        assertThat(this.service.findCharacterSheetById(this.testCharacterSheetWithID.getId())).isEqualTo(this.mapToDTO(this.testCharacterSheetWithID));
    }

    //    @Test
//    public void updateCharacterSheetTest(){
//        Note newCharacterSheet = new CharacterSheet("Corvus", 14L, 14L, 3000L);
//        Note updateCharacterSheet = new CharacterSheet(newCharacterSheet.getCharacterName(), newCharacterSheet.getMaxLevel(), newCharacterSheet.getCurrentLevel(), newCharacterSheet.getExp);
//        updateNote.setId(this.testCharacterSheetWithID.getId());
//        assertThat(this.service.updateCharacterSheet(this.testCharacterSheetWithID.getId() ,newCharacterSheet))
//                .isEqualTo(this.mapToDTO(updateCharacterSheet));
//    }

    @Test
    public void deleteCharacterSheetTest(){
        assertThat(this.service.deleteCharacterSheet(this.testCharacterSheetWithID.getId())).isFalse();
    }

}
