package com.qa.dnd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.dto.CharacterSheetDTO;
import com.qa.dnd.repo.CharacterSheetRepository;
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
public class CharacterSheetControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private CharacterSheetRepository repo;

    @Autowired
    private ModelMapper mapper;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private CharacterSheet testCharacterSheet;
    private CharacterSheet testCharacterSheetWithId;
    private long id;
    private CharacterSheetDTO characterSheetDTO;

    private CharacterSheetDTO mapToDTO(CharacterSheet characterSheet) {
        return this.mapper.map(characterSheet, CharacterSheetDTO.class);
    }

    @Before
    public void setUp() {
        this.repo.deleteAll();
        this.testCharacterSheet = new CharacterSheet("Corvus", 14L, 14L, 3000L);
        this.testCharacterSheetWithId = this.repo.save(testCharacterSheet);
        this.id = testCharacterSheetWithId.getId();
        this.characterSheetDTO = this.mapToDTO(testCharacterSheetWithId);
    }

    @Test
    public void getAllCharacterSheetTest() throws Exception {
        List<CharacterSheetDTO> characterSheetDTOList = new ArrayList<>();
        characterSheetDTOList.add(characterSheetDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllCharacterSheets")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(characterSheetDTOList));
    }

    @Test
    public void getCharacterSheetByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getCharacterSheetById/" + this.id)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(characterSheetDTO));
    }

    @Test
    public void createCharacterSheetTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createCharacterSheet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testCharacterSheet))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(characterSheetDTO));
    }

    @Test
    public void deleteCharacterSheetTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteCharacterSheet/" + this.id)
        ).andExpect(status().isNoContent());
    }
}
