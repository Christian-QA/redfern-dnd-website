package com.qa.domain;

import com.google.gson.internal.$Gson$Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "abilities")
public class Abilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abilitiesId;

    @Column(name = "strength")
    private String strength;
    @Column(name = "dexterity")
    private String dexterity;
    @Column(name = "constitution")
    private String constitution;
    @Column(name = "intelligence")
    private String intelligence;
    @Column(name = "wisdom")
    private String wisdom;
    @Column(name = "charisma")
    private String charisma;

    @ManyToOne(targetEntity = CharacterSheet.class)
    @JoinColumn(name="character_id")
    private CharacterSheet characterSheet;

    public Abilities() {
    }

    public Abilities(String strength, String dexterity,  String constitution,  String intelligence,  String wisdom,  String charisma) {
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
