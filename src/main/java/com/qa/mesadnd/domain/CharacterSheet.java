package com.qa.mesadnd.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "character_sheet")
@Proxy(lazy=false)
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

    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "characterSheet")
    private Set<Skills> skills = new HashSet<> ();

    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "characterSheet")
    private Set<Abilities> abilities = new HashSet<> ();

    public CharacterSheet() {
    }

    public CharacterSheet(String name, Long maxHp, Long currentHp, Long exp) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
    }

    public CharacterSheet(Long characterId, String name, Long maxHp, Long currentHp, Long exp) {
        this.characterId = characterId;
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.exp = exp;
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

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Abilities> abilities) {
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterSheet))
            return false;
        CharacterSheet that = (CharacterSheet) o;
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
        return "CharacterSheet{" +
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
