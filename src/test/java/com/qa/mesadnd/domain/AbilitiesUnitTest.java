package com.qa.mesadnd.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbilitiesUnitTest {

    private Abilities abilities;
    private Abilities other;

    @Before
    public void setUp() {
        abilities = new Abilities(1L,10L,10L,10L,10L,10L,10L);
        other = new Abilities(11L,12L,14L,15L,12L,14L);
    }

    @Test
    public void settersTest() {
        assertNotNull(abilities.getAbilitiesId());
        assertNotNull(abilities.getStrength ());
        assertNotNull(abilities.getDexterity ());
        assertNotNull(abilities.getConstitution ());
        assertNotNull(abilities.getIntelligence ());
        assertNotNull(abilities.getWisdom ());
        assertNotNull(abilities.getCharisma ());

        abilities.setAbilitiesId(null);
        assertNull(abilities.getAbilitiesId());
        abilities.setStrength(null);
        assertNull(abilities.getStrength());
        abilities.setDexterity (null);
        assertNull(abilities.getDexterity ());
        abilities.setConstitution(null);
        assertNull(abilities.getConstitution ());
        abilities.setIntelligence(null);
        assertNull(abilities.getIntelligence());
        abilities.setWisdom (null);
        assertNull(abilities.getWisdom ());
        abilities.setCharisma(null);
        assertNull(abilities.getCharisma ());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(abilities.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(abilities.equals(new Object()));
    }

    @Test
    public void createSkillsSheetWithId() {
        assertEquals(1L, abilities.getAbilitiesId(), 0);
        assertEquals(10L, abilities.getStrength (), 0);
        assertEquals(10L, abilities.getDexterity (), 0);
        assertEquals(10L, abilities.getConstitution (), 0);
        assertEquals(10L, abilities.getIntelligence (), 0);
        assertEquals(10L, abilities.getWisdom (), 0);
        assertEquals(10L, abilities.getCharisma (), 0);
    }

    @Test
    public void checkEquality() {
        assertTrue(abilities.equals(abilities));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertFalse(abilities.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void strengthNullButOtherStrengthNotNull() {
        abilities.setStrength(null);
        other.setAbilitiesId (1L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void strengthNotEqual() {
        other.setStrength(10L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void dexterityNullButOtherDexterityNotNull() {
        abilities.setDexterity (null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void dexterityNotEqual() {
        other.setDexterity (10L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void constitutionNullButOtherConstitutionNotNull() {
        abilities.setConstitution(null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void constitutionNotEqual() {
        other.setConstitution (10L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void intelligenceNullButOtherIntelligenceNotNull() {
        abilities.setIntelligence (null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void intelligenceNotEqual() {
        other.setIntelligence (10L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void wisdomNullButOtherWisdomNotNull() {
        abilities.setWisdom (null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void wisdomNotEqual() {
        other.setWisdom (10L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void charismaNullButOtherCharismaNotNull() {
        abilities.setCharisma (null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void charismaNotEqual() {
        other.setCharisma (10L);
        assertFalse(abilities.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void nullId() {
        abilities.setAbilitiesId (null);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void abilitiesIDDifferent() {
        other.setAbilitiesId (1L);
        assertFalse(abilities.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setAbilitiesId(2L);
        assertFalse(abilities.equals(other));
    }
    
    @Test
    public void hashCodeTestWithNull() {
        Abilities abilities = new Abilities(null, null, null, null, null, null, null);
        Abilities other = new Abilities(null, null, null, null, null, null, null);
        assertEquals(abilities.hashCode(), other.hashCode());
    }

}
