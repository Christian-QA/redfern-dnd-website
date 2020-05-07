package com.qa.dnd.dto;

import java.util.Objects;

public class SkillsDTO {

    private Long id;
    private String SkillName;

    public SkillsDTO(){
    }

    public SkillsDTO(String SkillName) {
        this.SkillName = SkillName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return SkillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SkillsDTO))
            return false;
        SkillsDTO skillsDTO = (SkillsDTO) o;
        return getId ().equals (skillsDTO.getId ()) &&
                getSkillName ().equals (skillsDTO.getSkillName ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getSkillName ());
    }
}
