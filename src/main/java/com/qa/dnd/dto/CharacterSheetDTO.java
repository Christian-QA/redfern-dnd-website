package com.qa.dnd.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterSheetDTO {

    private Long id;
    private String characterName;
    private Long maxHp;
    private Long currentHp;
    private Long exp;
    private List<SkillsDTO> skills = new ArrayList<> ();

    public CharacterSheetDTO() {
    }

    public CharacterSheetDTO(String characterName, Long maxHp, Long current_hp, Long exp) {
        super();
        this.characterName = characterName;
        this.maxHp = maxHp;
        this.currentHp = current_hp;
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

    public void setSkills(List<SkillsDTO> skills) {
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

    public List<SkillsDTO> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterSheetDTO))
            return false;
        CharacterSheetDTO that = (CharacterSheetDTO) o;
        return getId ().equals (that.getId ()) &&
                getCharacterName ().equals (that.getCharacterName ()) &&
                getMaxHp ().equals (that.getMaxHp ()) &&
                getCurrentHp ().equals (that.getCurrentHp ()) &&
                getExp ().equals (that.getExp ()) &&
                getSkills ().equals (that.getSkills ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getCharacterName (), getMaxHp (), getCurrentHp (), getExp (), getSkills ());
    }
}
