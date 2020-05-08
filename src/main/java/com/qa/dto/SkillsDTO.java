package com.qa.dto;

import java.util.Objects;

public class SkillsDTO {

    private Long id;
    private String skillName;
    private String statModifier;
    private Boolean fullProficiency;

    public SkillsDTO() {
    }

    public SkillsDTO(String title, String description) {
        this.skillName = skillName;
        this.statModifier = statModifier;
        this.fullProficiency = fullProficiency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return getId ().equals (skillsDTO.getId ()) &&
                getSkillName ().equals (skillsDTO.getSkillName ()) &&
                getStatModifier ().equals (skillsDTO.getStatModifier ()) &&
                getFullProficiency ().equals (skillsDTO.getFullProficiency ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getSkillName (), getStatModifier (), getFullProficiency ());
    }
}
