package com.qa.mesadnd.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "skills")
@Proxy(lazy=false)
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillsId;

    @Column(name = "skill_name", columnDefinition = "varchar(35) default 'Acrobatics' NOT NULL")
    private String skillName;
    @Column(name = "stat_modifier", columnDefinition = "varchar(12) default 'Dexterity' NOT NULL")
    private String statModifier;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "skills")
    private Set<CharacterSheet> characterSheet = new HashSet<> ();

    public Skills() {
    }

    public Skills(String skillName, String statModifier) {
        this.skillName = skillName;
        this.statModifier = statModifier;
    }

    public Skills(Long skillsId, String skillName, String statModifier) {
        this.skillsId = skillsId;
        this.skillName = skillName;
        this.statModifier = statModifier;
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

    public Set<CharacterSheet> getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(Set<CharacterSheet> characterSheet) {
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
                getCharacterSheet ().equals (skills.getCharacterSheet ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getSkillsId (), getSkillName(), getStatModifier(), getCharacterSheet ());
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skillsId=" + skillsId +
                ", skillName='" + skillName + '\'' +
                ", statModifier='" + statModifier + '\'' +
                ", characterSheet=" + characterSheet +
                '}';
    }
}
