package com.qa.dnd.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "charactersheets")
public class CharacterSheet {

    @Id
    @GeneratedValue
    private Long id;
    private String characterName;
    private Long maxHp;
    private Long currentHp;
    private Long exp;

    @OneToMany(mappedBy = "charactersheet", fetch = FetchType.EAGER)
    private List<Skills> skills = new ArrayList<>();

    public CharacterSheet() {
    }

    public CharacterSheet(String characterName, Long maxHp, Long currentHp, Long exp) {
        this.characterName = characterName;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setMaxHp(Long maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurrentHp(Long currentHp) {
        this.currentHp = currentHp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Long getMaxHp() {
        return maxHp;
    }

    public Long getCurrentHp() {
        return currentHp;
    }

    public Long getExp() {
        return exp;
    }

    public List<Skills> getSkills() {
        return skills;
    }
}
