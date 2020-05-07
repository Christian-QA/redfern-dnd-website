package com.qa.dnd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHARACTERSHEET")
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String character_name;
    private Long max_hp;
    private Long current_hp;
    private Long exp;

    public CharacterSheet() {
    }

    public CharacterSheet(String character_name, Long max_hp, Long current_hp, Long exp) {
        this.character_name = character_name;
        this.max_hp = max_hp;
        this.current_hp = current_hp;
        this.exp = exp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public void setMax_hp(Long max_hp) {
        this.max_hp = max_hp;
    }

    public void setCurrent_hp(Long current_hp) {
        this.current_hp = current_hp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Long getId() {
        return id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public Long getMax_hp() {
        return max_hp;
    }

    public Long getCurrent_hp() {
        return current_hp;
    }

    public Long getExp() {
        return exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterSheet))
            return false;
        CharacterSheet that = (CharacterSheet) o;
        return getId ().equals (that.getId ()) &&
                getCharacter_name ().equals (that.getCharacter_name ()) &&
                getMax_hp ().equals (that.getMax_hp ()) &&
                getCurrent_hp ().equals (that.getCurrent_hp ()) &&
                getExp().equals (that.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getCharacter_name (), getMax_hp (), getCurrent_hp (), getExp());
    }
}
