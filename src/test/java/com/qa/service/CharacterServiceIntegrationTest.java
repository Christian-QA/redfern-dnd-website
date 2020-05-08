package com.qa.service;

import com.qa.domain.Character;
import com.qa.dto.CharacterDTO;
import com.qa.repo.CharacterRepo;
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
public class CharacterServiceIntegrationTest {

    @Autowired
    private CharacterService service;

    @Autowired
    private CharacterRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Character testCharacter;

    private Character testCharacterWithID;

    private CharacterDTO mapToDTO(Character character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.testCharacter = new Character("Sinnis", 21L, 21L, 3000L);
        this.repository.deleteAll();
        this.testCharacterWithID = this.repository.save(this.testCharacter);
    }

    @Test
    public void readCharacterTest(){
        assertThat(this.service.readCharacter())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testCharacterWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void createSkillsTest(){
        assertEquals(this.mapToDTO(this.testCharacterWithID), this.service.createCharacter (testCharacter));
    }

    @Test
    public void findCharacterByIdTest(){
        assertThat(this.service.findCharacterById (this.testCharacterWithID.getId())).isEqualTo(this.mapToDTO(this.testCharacterWithID));
    }

    /// Need Update Test

    @Test
    public void deleteSkillsTest(){
        assertThat(this.service.deleteCharacter(this.testCharacterWithID.getId())).isFalse();
    }

}
