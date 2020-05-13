package com.qa.dto;

import java.util.*;

public class CharacterDTO {

    private Long id;
    private String name;
    private Long maxHp;
    private Long currentHp;
    private Long exp;
    private Collection<SkillsDTO> skills = new HashSet<>();
    private Collection<AbilitiesDTO> abilities = new HashSet<>();

    public CharacterDTO() {
    }

    public CharacterDTO(String name, Long maxHp, Long currentHp, Long exp) {
        super();
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<SkillsDTO> getSkills() {
        return skills;
    }

    public void setSkills(Collection<SkillsDTO> skills) {
        this.skills = skills;
    }

    public Collection<AbilitiesDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(Collection<AbilitiesDTO> abilities) {
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterDTO))
            return false;
        CharacterDTO that = (CharacterDTO) o;
        return getId ().equals (that.getId ()) &&
                getName ().equals (that.getName ()) &&
                getMaxHp ().equals (that.getMaxHp ()) &&
                getCurrentHp ().equals (that.getCurrentHp ()) &&
                getExp ().equals (that.getExp ()) &&
                getSkills ().equals (that.getSkills ()) &&
                getAbilities ().equals (that.getAbilities ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getName (), getMaxHp (), getCurrentHp (), getExp (), getSkills (), getAbilities ());
    }
}
