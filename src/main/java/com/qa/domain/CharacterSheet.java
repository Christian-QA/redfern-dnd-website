package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character_sheet")
public class CharacterSheet {

    @Id
    @GeneratedValue
    private Long characterId;

    @Column(name = "name")
    private String name;
    @Column(name = "max_hp")
    private Long maxHp;
    @Column(name = "current_hp")
    private Long currentHp;
    @Column(name = "exp")
    private Long exp;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "characterSheet", fetch = FetchType.EAGER)
    private List<Skills> skills;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "characterSheet", fetch = FetchType.EAGER)
    private List<Abilities> abilities;

    public CharacterSheet() {
        skills = new ArrayList<>();
        abilities = new ArrayList<>();
    }

    public CharacterSheet(String name, Long maxHp, Long currentHp, Long exp) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
        skills = new ArrayList<>();
        abilities = new ArrayList<>();
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long id) {
        this.characterId = id;
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

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }


}
