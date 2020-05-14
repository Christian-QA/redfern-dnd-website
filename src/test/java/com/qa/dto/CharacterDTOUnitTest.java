package com.qa.dto;

import com.qa.domain.CharacterSheet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterDTOUnitTest {

    private CharacterDTO characterDTO;
    private CharacterDTO other;

    @Before
    public void setUp() {
        characterDTO = new CharacterDTO(1L, "Sinnis", 20L, 20L, 3000L);
        other = new CharacterDTO(1L, "Corvus", 5L, 1L, 3000L);
    }

    @Test
    public void settersTest() {
        assertNotNull(characterDTO.getCharacterId());
        assertNotNull(characterDTO.getName ());
        assertNotNull(characterDTO.getMaxHp ());
        assertNotNull(characterDTO.getCurrentHp ());
        assertNotNull(characterDTO.getExp ());

        characterDTO.setCharacterId(null);
        assertNull(characterDTO.getCharacterId());
        characterDTO.setName(null);
        assertNull(characterDTO.getName());
        characterDTO.setMaxHp(null);
        assertNull(characterDTO.getMaxHp());
        characterDTO.setCurrentHp(null);
        assertNull(characterDTO.getCurrentHp());
        characterDTO.setExp(null);
        assertNull(characterDTO.getExp());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(characterDTO.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(characterDTO.equals(new Object()));
    }

    @Test
    public void createCharacterDTOWithId() {
        assertEquals(1L, characterDTO.getCharacterId(), 0);
        assertEquals("Sinnis", characterDTO.getName());
        assertEquals(20L, characterDTO.getMaxHp (), 0);
        assertEquals(20L, characterDTO.getCurrentHp (), 0);
        assertEquals(3000L, characterDTO.getExp (), 0);
    }

    @Test
    public void checkEquality() {
        assertTrue(characterDTO.equals(characterDTO));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertFalse(characterDTO.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void characterDTONameNullButOtherNameNotNull() {
        characterDTO.setName(null);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTONamesNotEqual() {
        other.setName("Nine");
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOMaxHpNullButOtherMaxHpNotNull() {
        characterDTO.setMaxHp(null);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOMaxHpNotEqual() {
        other.setMaxHp(5L);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOCurrentHpNullButOtherCurrentHpNotNull() {
        characterDTO.setCurrentHp(null);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOCurrentHpNotEqual() {
        other.setCurrentHp(5L);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOExpNullButOtherExpNotNull() {
        characterDTO.setExp(null);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOExpNotEqual() {
        other.setExp(5L);
        assertFalse(characterDTO.equals(other));
    }

    @Test(expected = NullPointerException.class)
    public void nullId() {
        characterDTO.setCharacterId(null);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void characterDTOIDDifferent() {
        other.setCharacterId(1L);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void otherIdDifferent() {
        other.setCharacterId(2L);
        assertFalse(characterDTO.equals(other));
    }

    @Test
    public void constructorWithoutId() {
        CharacterDTO characterDTO = new CharacterDTO("Sinnis", 20L, 20L, 3000L);
        assertNull(characterDTO.getCharacterId ());
        assertNotNull(characterDTO.getName());
        assertNotNull(characterDTO.getMaxHp ());
        assertNotNull(characterDTO.getCurrentHp ());
        assertNotNull(characterDTO.getExp ());
    }

    @Test
    public void hashCodeTestWithNull() {
        CharacterDTO characterDTO = new CharacterDTO(null, null, null, null);
        CharacterDTO other = new CharacterDTO(null, null, null, null);
        assertEquals(characterDTO.hashCode(), other.hashCode());
    }
}
