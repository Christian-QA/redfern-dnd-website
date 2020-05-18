package com.qa.mesadnd.service;

import com.qa.mesadnd.domain.CharacterSheet;
import com.qa.mesadnd.dto.CharacterDTO;
import com.qa.mesadnd.repo.CharacterRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:resources/test.properties")
@SpringBootTest
public class CharacterServiceIntegrationTest {

    @Autowired
    private CharacterService service;

    @Autowired
    private CharacterRepo repository;

    @Autowired
    private ModelMapper mapper;

    private CharacterSheet testCharacterSheet;

    private CharacterSheet testCharacterSheetWithID;

    private CharacterDTO mapToDTO(CharacterSheet characterSheet){
        return this.mapper.map(characterSheet, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.testCharacterSheet = new CharacterSheet ("Sinnis", 21L, 21L, 3000L);
        this.repository.deleteAll();
        this.testCharacterSheetWithID = this.repository.save(this.testCharacterSheet);
    }

    @Test
    public void readCharacterTest(){
        assertThat(this.service.readCharacter())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testCharacterSheetWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void createCharacterTest(){
        assertEquals(this.mapToDTO(this.testCharacterSheetWithID), this.service.createCharacter (testCharacterSheet));
    }

    @Test
    public void findCharacterByIdTest(){
        assertThat(this.service.findCharacterById (this.testCharacterSheetWithID.getCharacterId ())).isEqualTo(this.mapToDTO(this.testCharacterSheetWithID));
    }

    /// Need Update Test

    @Test
    public void deleteSkillsTest(){
        assertThat(this.service.deleteCharacter(this.testCharacterSheetWithID.getCharacterId ())).isFalse();
    }

}
