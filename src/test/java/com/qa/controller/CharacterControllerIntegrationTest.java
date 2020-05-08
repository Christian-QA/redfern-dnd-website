package com.qa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Character;
import com.qa.dto.CharacterDTO;
import com.qa.repo.CharacterRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private CharacterRepo repository;

    @Autowired
    private ModelMapper mapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Character testCharacter;

    private Character testCharacterWithID;

    private long id;

    private CharacterDTO characterDTO;

    private CharacterDTO mapToDTO(Character character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testCharacter = new Character ("Sinnis", 21L, 21L, 3000L);
        this.testCharacterWithID = this.repository.save(testCharacter);
        this.id = testCharacterWithID.getId();
        this.characterDTO = this.mapToDTO(testCharacterWithID);
    }

    @Test
    public void getAllCharacterTest() throws Exception {
        List<CharacterDTO> characterDTOList = new ArrayList<> ();
        characterDTOList.add(characterDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllCharacters")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(characterDTOList));
    }

    @Test
    public void getCharacterByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getCharacterById/" + this.id)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(characterDTO));
    }

    @Test
    public void createCharacterTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createCharacter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testCharacter))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(characterDTO));
    }

    @Test
    public void deleteCharacterTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteCharacter/" + this.id)
        ).andExpect(status().isNoContent());
    }
}
