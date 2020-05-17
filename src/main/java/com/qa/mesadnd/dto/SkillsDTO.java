package com.qa.mesadnd.dto;

import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
public class SkillsDTO {

    private Long skillsId;
    private String skillName;
    private String statModifier;

    public SkillsDTO() {
    }

    public SkillsDTO(String skillName, String statModifier) {
        super();
        this.skillName = skillName;
        this.statModifier = statModifier;
    }

    public SkillsDTO(Long skillsId, String skillName, String statModifier) {
        super();
        this.skillsId = skillsId;
        this.skillName = skillName;
        this.statModifier = statModifier;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SkillsDTO))
            return false;
        SkillsDTO skillsDTO = (SkillsDTO) o;
        return getSkillsId ().equals (skillsDTO.getSkillsId ()) &&
                getSkillName ().equals (skillsDTO.getSkillName ()) &&
                getStatModifier ().equals (skillsDTO.getStatModifier ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getSkillsId (), getSkillName (), getStatModifier ());
    }

    @Override
    public String toString() {
        return "SkillsDTO{" +
                "skillsId=" + skillsId +
                ", skillName='" + skillName + '\'' +
                ", statModifier='" + statModifier + '\'' +
                '}';
    }
}
