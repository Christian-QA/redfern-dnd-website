package com.qa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkillsTest {

    private Skills skills;
    private Skills other;

    @Before
    public void setUp() {
        skills = new Skills(1L,"Perception", "Wisdom", Boolean.TRUE);
        other = new Skills(1L, "History", "Intelligence", Boolean.TRUE);
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
    public void characterSheetNameNullButOtherNameNotNull() {
        skills.setSkillName(null);
        assertFalse(skills.equals(other));
    }

    @Test
    public void characterSheetNamesNotEqual() {
        other.setSkillName("Perception");
        assertFalse(skills.equals(other));
    }

    @Test
    public void characterSheetMaxHpNullButOtherMaxHpNotNull() {
        skills.setMaxHp(null);
        assertFalse(skills.equals(other));
    }

    @Test
    public void characterSheetMaxHpNotEqual() {
        other.setMaxHp(5L);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetCurrentHpNullButOtherCurrentHpNotNull() {
        characterSheet.setCurrentHp(null);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetCurrentHpNotEqual() {
        other.setCurrentHp(5L);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetExpNullButOtherExpNotNull() {
        characterSheet.setExp(null);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetExpNotEqual() {
        other.setExp(5L);
        assertFalse(characterSheet.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void nullId() {
        characterSheet.setCharacterId(null);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetIDDifferent() {
        other.setCharacterId(1L);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setCharacterId(2L);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        CharacterSheet characterSheet = new CharacterSheet("Sinnis", 20L, 20L, 3000L);
        assertNull(characterSheet.getCharacterId ());
        assertNotNull(characterSheet.getName());
        assertNotNull(characterSheet.getMaxHp ());
        assertNotNull(characterSheet.getCurrentHp ());
        assertNotNull(characterSheet.getExp ());
    }

    @Test
    public void hashCodeTestWithNull() {
        CharacterSheet characterSheet = new CharacterSheet(null, null, null, null);
        CharacterSheet other = new CharacterSheet(null, null, null, null);
        assertEquals(characterSheet.hashCode(), other.hashCode());
    }

}
