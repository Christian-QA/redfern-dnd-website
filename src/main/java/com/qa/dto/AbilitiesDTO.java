package com.qa.dto;

import java.util.Objects;

public class AbilitiesDTO {

    private Long abilitiesId;
    private String strength;
    private String dexterity;
    private String constitution;
    private String intelligence;
    private String wisdom;
    private String charisma;

    public AbilitiesDTO() {
    }

    public AbilitiesDTO(String strength, String dexterity,  String constitution,  String intelligence,  String wisdom,  String charisma) {
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

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
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
}
