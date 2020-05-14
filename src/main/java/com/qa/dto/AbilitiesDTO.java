package com.qa.dto;

import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
public class AbilitiesDTO {

    private Long abilitiesId;
    private Long strength;
    private Long dexterity;
    private Long constitution;
    private Long intelligence;
    private Long wisdom;
    private Long charisma;

    public AbilitiesDTO() {
    }

    public AbilitiesDTO(Long strength, Long dexterity,  Long constitution,  Long intelligence,  Long wisdom,  Long charisma) {
        super();
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public AbilitiesDTO(Long abilitiesId, Long strength, Long dexterity,  Long constitution,  Long intelligence,  Long wisdom,  Long charisma) {
        this.abilitiesId = abilitiesId;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public Long getAbilitiesId() {
        return abilitiesId;
    }

    public void setAbilitiesId(Long abilitiesId) {
        this.abilitiesId = abilitiesId;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getDexterity() {
        return dexterity;
    }

    public void setDexterity(Long dexterity) {
        this.dexterity = dexterity;
    }

    public Long getConstitution() {
        return constitution;
    }

    public void setConstitution(Long constitution) {
        this.constitution = constitution;
    }

    public Long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Long intelligence) {
        this.intelligence = intelligence;
    }

    public Long getWisdom() {
        return wisdom;
    }

    public void setWisdom(Long wisdom) {
        this.wisdom = wisdom;
    }

    public Long getCharisma() {
        return charisma;
    }

    public void setCharisma(Long charisma) {
        this.charisma = charisma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AbilitiesDTO))
            return false;
        AbilitiesDTO that = (AbilitiesDTO) o;
        return getAbilitiesId ().equals (that.getAbilitiesId ()) &&
                getStrength ().equals (that.getStrength ()) &&
                getDexterity ().equals (that.getDexterity ()) &&
                getConstitution ().equals (that.getConstitution ()) &&
                getIntelligence ().equals (that.getIntelligence ()) &&
                getWisdom ().equals (that.getWisdom ()) &&
                getCharisma ().equals (that.getCharisma ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getAbilitiesId (), getStrength (), getDexterity (), getConstitution (), getIntelligence (), getWisdom (), getCharisma ());
    }

    @Override
    public String toString() {
        return "AbilitiesDTO{" +
                "abilitiesId=" + abilitiesId +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }
}
