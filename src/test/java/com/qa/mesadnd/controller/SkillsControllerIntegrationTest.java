package com.qa.mesadnd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.mesadnd.domain.Skills;
import com.qa.mesadnd.dto.SkillsDTO;
import com.qa.mesadnd.repo.SkillsRepo;
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
@TestPropertySource(locations="classpath:resources/test.properties")
@AutoConfigureMockMvc
public class SkillsControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private SkillsRepo repository;

    @Autowired
    private ModelMapper mapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Skills testSkills;

    private Skills testSkillsWithID;

    private long id;

    private SkillsDTO skillsDTO;

    private SkillsDTO mapToDTO(Skills skills){
        return this.mapper.map(skills, SkillsDTO.class);
    }

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testSkills = new Skills ("Arcana", "Intelligence");
        this.testSkillsWithID = this.repository.save(testSkills);
        this.id = testSkillsWithID.getSkillsId ();
        this.skillsDTO = this.mapToDTO(testSkillsWithID);
    }

    @Test
    public void getAllSkillsTest() throws Exception {
        List<SkillsDTO> skillsDTOList = new ArrayList<>();
        skillsDTOList.add(skillsDTO);
        String content = this.mock.perform(
            request(HttpMethod.GET, "/getAllSkills")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(skillsDTOList));
    }

    @Test
    public void getSkillsByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getSkillsById/" + this.id)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(skillsDTO));
    }

    @Test
    public void createSkillsTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createSkills")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testSkills))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(skillsDTO));
    }

    @Test
    public void deleteSkillsTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteSkills/" + this.id)
        ).andExpect(status().isNoContent());
    }


}
