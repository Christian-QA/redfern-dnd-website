package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "abilities")
public class Abilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abilitiesId;

    @Column(name = "strength")
    private Long strength;
    @Column(name = "dexterity")
    private Long dexterity;
    @Column(name = "constitution")
    private Long constitution;
    @Column(name = "intelligence")
    private Long intelligence;
    @Column(name = "wisdom")
    private Long wisdom;
    @Column(name = "charisma")
    private Long charisma;

    @ManyToOne(targetEntity = CharacterSheet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="character_id")
    private CharacterSheet characterSheet;

    public Abilities() {
    }

    public Abilities(Long strength, Long dexterity,  Long constitution,  Long intelligence,  Long wisdom,  Long charisma) {
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

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Abilities))
            return false;
        Abilities abilities = (Abilities) o;
        return getAbilitiesId ().equals (abilities.getAbilitiesId ()) &&
                getStrength ().equals (abilities.getStrength ()) &&
                getDexterity ().equals (abilities.getDexterity ()) &&
                getConstitution ().equals (abilities.getConstitution ()) &&
                getIntelligence ().equals (abilities.getIntelligence ()) &&
                getWisdom ().equals (abilities.getWisdom ()) &&
                getCharisma ().equals (abilities.getCharisma ()) &&
                getCharacterSheet ().equals (abilities.getCharacterSheet ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getAbilitiesId (), getStrength (), getDexterity (), getConstitution (), getIntelligence (), getWisdom (), getCharisma (), getCharacterSheet ());
    }
}
