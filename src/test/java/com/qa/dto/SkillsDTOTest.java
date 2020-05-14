package com.qa.dto;

import com.qa.domain.Skills;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkillsDTOTest {

    private SkillsDTO skills;
    private SkillsDTO other;

    @Before
    public void setUp() {
        skills = new SkillsDTO(1L,"Perception", "Wisdom", Boolean.TRUE);
        other = new SkillsDTO("History", "Intelligence", Boolean.TRUE);
    }

    @Test
    public void settersTest() {
        assertNotNull(skills.getSkillsId());
        assertNotNull(skills.getSkillName ());
        assertNotNull(skills.getStatModifier ());
        assertNotNull(skills.getFullProficiency ());

        skills.setSkillsId(null);
        assertNull(skills.getSkillsId());
        skills.setSkillName(null);
        assertNull(skills.getSkillName());
        skills.setStatModifier (null);
        assertNull(skills.getStatModifier ());
        skills.setFullProficiency(null);
        assertNull(skills.getFullProficiency ());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(skills.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(skills.equals(new Object()));
    }

    @Test
    public void createSkillsSheetWithId() {
        assertEquals(1L, skills.getSkillsId(), 0);
        assertEquals("Perception", skills.getSkillName ());
        assertEquals("Wisdom", skills.getStatModifier ());
        assertEquals(Boolean.TRUE, skills.getFullProficiency ());
    }

    @Test
    public void checkEquality() {
        assertTrue(skills.equals(skills));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertFalse(skills.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void skillsNameNullButOtherNameNotNull() {
        skills.setSkillName(null);
        other.setSkillsId (1L);
        assertFalse(skills.equals(other));
    }

    @Test
    public void skillsNamesNotEqual() {
        other.setSkillName("Perception");
        assertFalse(skills.equals(other));
    }

    @Test
    public void skillModifierNullButOtherSkillModifierNotNull() {
        skills.setStatModifier (null);
        assertFalse(skills.equals(other));
    }

    @Test
    public void skillModifierNotEqual() {
        other.setStatModifier ("Wisdom");
        assertFalse(skills.equals(other));
    }

    @Test
    public void skillsFullProficiencyNullButOtherFullProficiencyNotNull() {
        skills.setFullProficiency(null);
        assertFalse(skills.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void nullId() {
        skills.setSkillsId (null);
        assertFalse(skills.equals(other));
    }

    @Test
    public void characterSheetIDDifferent() {
        other.setSkillsId(1L);
        assertFalse(skills.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setSkillsId(2L);
        assertFalse(skills.equals(other));
    }

    @Test
    public void hashCodeTestWithNull() {
        Skills skills = new Skills(null, null, null, null);
        Skills other = new Skills(null, null, null);
        assertEquals(skills.hashCode(), other.hashCode());
    }

}
