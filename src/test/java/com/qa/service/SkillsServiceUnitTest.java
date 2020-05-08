package com.qa.service;

import com.qa.domain.Skills;
import com.qa.dto.SkillsDTO;
import com.qa.exceptions.SkillNotFoundException;
import com.qa.repo.SkillsRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class SkillsServiceUnitTest {

    @InjectMocks
    private SkillsService service;

    @Mock
    private SkillsRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Skills> skillsList;

    private Skills testSkills;

    private final long id = 1L;

    private Skills testSkillsWithID;

    private SkillsDTO skillsDTO;

    private SkillsDTO mapToDTO(Skills skills){
        return this.mapper.map(skills, SkillsDTO.class);
    }

    @Before
    public void setUp(){
        this.skillsList = new ArrayList<>();
        this.testSkills = new Skills ("Arcana", "Intelligence", Boolean.TRUE);
        this.skillsList.add(testSkills);
        this.testSkillsWithID = new Skills (testSkills.getSkillName(), testSkills.getStatModifier(), testSkills.getFullProficiency());
        this.testSkillsWithID.setId(id);
        this.skillsDTO = this.mapToDTO(testSkillsWithID);
    }

    @Test
    public void getAllSkillsTest(){
        when(repository.findAll()).thenReturn(this.skillsList);
        when(this.mapper.map(testSkillsWithID, SkillsDTO.class)).thenReturn(skillsDTO);
        assertFalse("Service returned no Notes", this.service.readSkills ().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createSkillsTest(){
        when(repository.save(testSkills)).thenReturn(testSkillsWithID);
        when(this.mapper.map(testSkillsWithID, SkillsDTO.class)).thenReturn(skillsDTO);
        assertEquals(this.service.createSkills (testSkills), this.skillsDTO);
        verify(repository, times(1)).save(this.testSkills);
    }

    @Test
    public void findSkillsByIdTest(){
        when(this.repository.findById(id)).thenReturn(java.util.Optional.ofNullable(testSkillsWithID));
        when(this.mapper.map(testSkillsWithID, SkillsDTO.class)).thenReturn(skillsDTO);
        assertEquals(this.service.findSkillsById (this.id), skillsDTO);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void deleteSkillsByExistingId(){
        when(this.repository.existsById(id)).thenReturn(true, false);
        assertFalse(service.deleteSkills (id));
        verify(repository, times(1)).deleteById(id);
        verify(repository, times(2)).existsById(id);
    }

    @Test(expected = SkillNotFoundException.class)
    public void deleteSkillsByNonExistingId(){
        when(this.repository.existsById(id)).thenReturn(false);
        service.deleteSkills (id);
        verify(repository, times(1)).existsById(id);
    }

//    @Test
//    public void updateNoteTest(){
//
//        Note newNote = new Note("Favourite movies", "The grinch");
//        Note updateNote = new Note(newNote.getTitle(), newNote.getDescription());
//        updateNote.setId(id);
//
//        NoteDTO updateNoteDTO = new ModelMapper().map(updateNote, NoteDTO.class);
//
//        when(this.repository.findById(id)).thenReturn(java.util.Optional.ofNullable(testNoteWithID));
//        when(this.repository.save(updateNote)).thenReturn(updateNote);
//        when(this.mapper.map(updateNote, NoteDTO.class)).thenReturn(updateNoteDTO);
//
//        assertEquals(updateNoteDTO, this.service.updateNote(id, newNote));
//        verify(this.repository, times(1)).findById(id);
//        verify(this.repository, times(1)).save(updateNote);
//    }

}
