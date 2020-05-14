package com.qa.mesadnd.domain;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class CharacterSheetUnitTest {

    private CharacterSheet characterSheet;
    private CharacterSheet other;

    @Before
    public void setUp() {
        characterSheet = new CharacterSheet(1L, "Sinnis", 20L, 20L, 3000L);
        other = new CharacterSheet("Corvus", 5L, 1L, 3000L);
    }

    @Test
    public void settersTest() {
        assertNotNull(characterSheet.getCharacterId());
        assertNotNull(characterSheet.getName ());
        assertNotNull(characterSheet.getMaxHp ());
        assertNotNull(characterSheet.getCurrentHp ());
        assertNotNull(characterSheet.getExp ());

        characterSheet.setCharacterId(null);
        assertNull(characterSheet.getCharacterId());
        characterSheet.setName(null);
        assertNull(characterSheet.getName());
        characterSheet.setMaxHp(null);
        assertNull(characterSheet.getMaxHp());
        characterSheet.setCurrentHp(null);
        assertNull(characterSheet.getCurrentHp());
        characterSheet.setExp(null);
        assertNull(characterSheet.getExp());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(characterSheet.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(characterSheet.equals(new Object()));
    }

    @Test
    public void createCharacterSheetWithId() {
        assertEquals(1L, characterSheet.getCharacterId(), 0);
        assertEquals("Sinnis", characterSheet.getName());
        assertEquals(20L, characterSheet.getMaxHp (), 0);
        assertEquals(20L, characterSheet.getCurrentHp (), 0);
        assertEquals(3000L, characterSheet.getExp (), 0);
    }

    @Test
    public void checkEquality() {
        assertTrue(characterSheet.equals(characterSheet));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertFalse(characterSheet.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void characterSheetNameNullButOtherNameNotNull() {
        characterSheet.setName(null);
        other.setCharacterId (1L);
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetNamesNotEqual() {
        other.setName("Tyche");
        assertFalse(characterSheet.equals(other));
    }

    @Test
    public void characterSheetMaxHpNullButOtherMaxHpNotNull() {
        characterSheet.setMaxHp(null);
        assertFalse(characterSheet.equals(other));
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
