package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillsId;

    @Column(name = "skill_name")
    private String skillName;
    @Column(name = "stat_modifier")
    private String statModifier;
    @Column(name = "full_proficiency")
    private Boolean fullProficiency;

    @ManyToOne(targetEntity = CharacterSheet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="character_id")
    private CharacterSheet characterSheet;

    public Skills() {
    }

    public Skills(String skillName, String statModifier, Boolean fullProficiency) {
        this.skillName = skillName;
        this.statModifier = statModifier;
        this.fullProficiency = fullProficiency;
    }

    public Long getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Long id) {
        this.skillsId = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String title) {
        this.skillName = title;
    }

    public String getStatModifier() {
        return statModifier;
    }

    public void setStatModifier(String statModifier) {
        this.statModifier = statModifier;
    }

    public Boolean getFullProficiency() {
        return fullProficiency;
    }

    public void setFullProficiency(Boolean fullProficiency) {
        this.fullProficiency = fullProficiency;
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
        if (!(o instanceof Skills))
            return false;
        Skills skills = (Skills) o;
        return getSkillsId ().equals (skills.getSkillsId ()) &&
                getSkillName ().equals (skills.getSkillName ()) &&
                getStatModifier ().equals (skills.getStatModifier ()) &&
                getFullProficiency ().equals (skills.getFullProficiency ()) &&
                getCharacterSheet ().equals (skills.getCharacterSheet ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getSkillsId (), getSkillName(), getStatModifier(), getFullProficiency(), getCharacterSheet ());
    }
}
