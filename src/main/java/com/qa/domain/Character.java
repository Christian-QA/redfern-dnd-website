package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "character", fetch = FetchType.LAZY)
    private List<Skills> skills = new ArrayList<>();

    public Character() {
    }

    public Character(String name) {
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

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }
}
