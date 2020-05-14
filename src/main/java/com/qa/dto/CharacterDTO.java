package com.qa.dto;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class CharacterDTO {

    private Long characterId;
    private String name;
    private Long maxHp;
    private Long currentHp;
    private Long exp;
    private Set<SkillsDTO> skills = new HashSet<> ();
    private Set<AbilitiesDTO> abilities = new HashSet<> ();

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

    public Set<SkillsDTO> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillsDTO> skills) {
        this.skills = skills;
    }

    public Set<AbilitiesDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<AbilitiesDTO> abilities) {
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

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "characterId=" + characterId +
                ", name='" + name + '\'' +
                ", maxHp=" + maxHp +
                ", currentHp=" + currentHp +
                ", exp=" + exp +
                ", skills=" + skills.toString() +
                ", abilities=" + abilities.toString() +
                '}';
    }
}
