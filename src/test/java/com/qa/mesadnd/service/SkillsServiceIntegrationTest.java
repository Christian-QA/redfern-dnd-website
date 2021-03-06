package com.qa.mesadnd.service;

import com.qa.mesadnd.domain.Skills;
import com.qa.mesadnd.dto.SkillsDTO;
import com.qa.mesadnd.repo.SkillsRepo;
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
@SpringBootTest
public class SkillsServiceIntegrationTest {

    @Autowired
    private SkillsService service;

    @Autowired
    private SkillsRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Skills testSkills;

    private Skills testSkillsWithID;

    private SkillsDTO mapToDTO(Skills skills){
        return this.mapper.map(skills, SkillsDTO.class);
    }

    @Before
    public void setUp(){
        this.testSkills = new Skills ("Arcana", "Intelligence");
        this.repository.deleteAll();
        this.testSkillsWithID = this.repository.save(this.testSkills);
    }

    @Test
    public void readSkillsTest(){
        assertThat(this.service.readSkills ())
        .isEqualTo(
                Stream.of(this.mapToDTO(testSkillsWithID)).collect(Collectors.toSet())
        );
    }

    @Test
    public void createSkillsTest(){
        assertEquals(this.mapToDTO(this.testSkillsWithID), this.service.createSkills (testSkills));
    }

    @Test
    public void findSkillsByIdTest(){
        assertThat(this.service.findSkillsById (this.testSkillsWithID.getSkillsId ())).isEqualTo(this.mapToDTO(this.testSkillsWithID));
    }

    @Test
    public void deleteSkillsTest(){
        assertThat(this.service.deleteSkills (this.testSkillsWithID.getSkillsId ())).isFalse();
    }
}
