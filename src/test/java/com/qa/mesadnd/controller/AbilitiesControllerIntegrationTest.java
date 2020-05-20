package com.qa.mesadnd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.mesadnd.domain.Abilities;
import com.qa.mesadnd.dto.AbilitiesDTO;
import com.qa.mesadnd.repo.AbilitiesRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
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
public class AbilitiesControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private AbilitiesRepo repository;

    @Autowired
    private ModelMapper mapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Abilities testAbilities;

    private Abilities testAbilitiesWithID;

    private long id;

    private AbilitiesDTO abilitiesDTO;

    private AbilitiesDTO mapToDTO(Abilities abilities){
        return this.mapper.map(abilities, AbilitiesDTO.class);
    }

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testAbilities = new Abilities (10L, 10L, 10L, 10L, 10L, 10L);
        this.testAbilitiesWithID = this.repository.save(testAbilities);
        this.id = testAbilitiesWithID.getAbilitiesId ();
        this.abilitiesDTO = this.mapToDTO(testAbilitiesWithID);
    }

    @Test
    public void getAllAbilitiesTest() throws Exception {
        List<AbilitiesDTO> abilitiesDTOList = new ArrayList<>();
        abilitiesDTOList.add(abilitiesDTO);
        String content = this.mock.perform(
            request(HttpMethod.GET, "/getAllAbilities")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(abilitiesDTOList));
    }

    @Test
    public void getAbilitiesByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAbilitiesById/" + this.id)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(abilitiesDTO));
    }

    @Test
    public void createAbilitiesTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createAbilities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testAbilities))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(abilitiesDTO));
    }

    @Test
    public void deleteAbilitiesTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteAbilities/" + this.id)
        ).andExpect(status().isNoContent());
    }


}
