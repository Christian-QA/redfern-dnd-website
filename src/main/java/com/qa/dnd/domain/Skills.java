package com.qa.dnd.domain;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    private Long id;

    private String SkillName;

    @OneToOne
    @MapsId
    private CharacterSheet characterSheet;

    public Skills() {
    }

    public Skills(String skillName, CharacterSheet characterSheet) {
        SkillName = skillName;
        this.characterSheet = characterSheet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return SkillName;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }


}
