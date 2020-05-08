package com.qa.dto;

import java.util.ArrayList;
import java.util.List;

public class CharacterDTO {

    private Long id;
    private String name;
    private List<SkillsDTO> notes = new ArrayList<>();

    public CharacterDTO() {
    }

    public CharacterDTO(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillsDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<SkillsDTO> notes) {
        this.notes = notes;
    }

}
