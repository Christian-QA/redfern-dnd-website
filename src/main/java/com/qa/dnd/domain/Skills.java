package com.qa.dnd.domain;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;
    private String SkillName;


    @ManyToOne
    @MapsId
    private CharacterSheet characterSheet;

    public Skills() {
    }

    public Skills(String skillName, CharacterSheet characterSheet) {
        SkillName = skillName;
        this.characterSheet = characterSheet;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    public Long getSid() {
        return sid;
    }


    public String getSkillName() {
        return SkillName;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }


}
