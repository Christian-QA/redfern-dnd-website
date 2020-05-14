package com.qa.dto;

import java.util.*;

public class CharacterDTO {

    private Long characterId;
    private String name;
    private Long maxHp;
    private Long currentHp;
    private Long exp;
    private List<SkillsDTO> skills = new ArrayList<> ();
    private List<AbilitiesDTO> abilities = new ArrayList<> ();

    public CharacterDTO() {
    }

    public CharacterDTO(String name, Long maxHp, Long currentHp, Long exp) {
        super();
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
    }

    public CharacterDTO(Long characterId, String name, Long maxHp, Long currentHp, Long exp) {
        this.characterId = characterId;
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Long maxHp) {
        this.maxHp = maxHp;
    }

    public Long getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(Long currentHp) {
        this.currentHp = currentHp;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public List<SkillsDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsDTO> skills) {
        this.skills = skills;
    }

    public List<AbilitiesDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitiesDTO> abilities) {
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterDTO))
            return false;
        CharacterDTO that = (CharacterDTO) o;
        return getCharacterId ().equals (that.getCharacterId ()) &&
                getName ().equals (that.getName ()) &&
                getMaxHp ().equals (that.getMaxHp ()) &&
                getCurrentHp ().equals (that.getCurrentHp ()) &&
                getExp ().equals (that.getExp ()) &&
                getSkills ().equals (that.getSkills ()) &&
                getAbilities ().equals (that.getAbilities ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getCharacterId (), getName (), getMaxHp (), getCurrentHp (), getExp (), getSkills (), getAbilities ());
    }
}
