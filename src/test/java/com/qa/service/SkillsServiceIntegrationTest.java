package com.qa.service;

import com.qa.domain.Skills;
import com.qa.dto.SkillsDTO;
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
        this.testSkills = new Skills ("My title", "my description");
        this.repository.deleteAll();
        this.testSkillsWithID = this.repository.save(this.testSkills);
    }

    @Test
    public void readSkillsTest(){
        assertThat(this.service.readSkills ())
        .isEqualTo(
                Stream.of(this.mapToDTO(testSkillsWithID)).collect(Collectors.toList())
        );
    }

    @Test
    public void createSkillsTest(){
        assertEquals(this.mapToDTO(this.testSkillsWithID), this.service.createSkills (testSkills));
    }

    @Test
    public void findSkillsByIdTest(){
        assertThat(this.service.findSkillsById (this.testSkillsWithID.getId())).isEqualTo(this.mapToDTO(this.testSkillsWithID));
    }


//    @Test
//    public void updateNoteTest(){
//        Note newNote = new Note("Favourite movies", "The grinch");
//        Note updateNote = new Note(newNote.getTitle(), newNote.getDescription());
//        updateNote.setId(this.testNoteWithID.getId());
//        assertThat(this.service.updateNote(this.testNoteWithID.getId() ,newNote))
//                .isEqualTo(this.mapToDTO(updateNote));
//    }

    @Test
    public void deleteSkillsTest(){
        assertThat(this.service.deleteSkills (this.testSkillsWithID.getId())).isFalse();
    }


}
