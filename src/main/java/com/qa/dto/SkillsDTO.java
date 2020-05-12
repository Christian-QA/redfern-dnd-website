package com.qa.dto;

import java.util.Objects;

public class SkillsDTO {

    private Long skillsId;
    private String skillName;
    private String statModifier;
    private Boolean fullProficiency;

    public SkillsDTO() {
    }

    public SkillsDTO(String skillName, String statModifier, Boolean fullProficiency) {
        this.skillName = skillName;
        this.statModifier = statModifier;
        this.fullProficiency = fullProficiency;
    }

    public Long getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Long skillsId) {
        this.skillsId = skillsId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SkillsDTO))
            return false;
        SkillsDTO skillsDTO = (SkillsDTO) o;
        return getSkillsId ().equals (skillsDTO.getSkillsId ()) &&
                getSkillName ().equals (skillsDTO.getSkillName ()) &&
                getStatModifier ().equals (skillsDTO.getStatModifier ()) &&
                getFullProficiency ().equals (skillsDTO.getFullProficiency ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getSkillsId (), getSkillName (), getStatModifier (), getFullProficiency ());
    }
}
