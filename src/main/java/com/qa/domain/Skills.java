package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String description;

    @ManyToOne(targetEntity = Character.class)
    private Character character;

    public Skills() {
    }

    public Skills(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Skills other = (Skills) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            return other.title == null;
        } else
            return title.equals (other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

}
