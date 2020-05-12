package com.qa.service;

import com.qa.domain.Abilities;
import com.qa.domain.Skills;
import com.qa.dto.AbilitiesDTO;
import com.qa.dto.SkillsDTO;
import com.qa.repo.AbilitiesRepo;
import com.qa.repo.SkillsRepo;
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
public class AbilitiesServiceIntegrationTest {

    @Autowired
    private AbilitiesService service;

    @Autowired
    private AbilitiesRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Abilities testAbilities;

    private Abilities testAbilitiesWithID;

    private AbilitiesDTO mapToDTO(Abilities abilities){
        return this.mapper.map(abilities, AbilitiesDTO.class);
    }

    @Before
    public void setUp(){
        this.testAbilities = new Abilities (10L, 10L, 10L, 10L, 10L, 10L);
        this.repository.deleteAll();
        this.testAbilitiesWithID = this.repository.save(this.testAbilities);
    }

    @Test
    public void readAbilitiesTest(){
        assertThat(this.service.readAbilities ())
        .isEqualTo(
                Stream.of(this.mapToDTO(testAbilitiesWithID)).collect(Collectors.toSet())
        );
    }

    @Test
    public void createAbilitiesTest(){
        assertEquals(this.mapToDTO(this.testAbilitiesWithID), this.service.createAbilities (testAbilities));
    }

    @Test
    public void findAbilitiesByIdTest(){
        assertThat(this.service.findAbilitiesById (this.testAbilitiesWithID.getAbilitiesId ())).isEqualTo(this.mapToDTO(this.testAbilitiesWithID));
    }

    @Test
    public void deleteAbilitiesTest(){
        assertThat(this.service.deleteAbilities (this.testAbilitiesWithID.getAbilitiesId ())).isFalse();
    }
}
