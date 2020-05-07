package com.qa.dnd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CharacterSheets")
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String characterName;
    private Long maxHp;
    private Long currentHp;
    private Long exp;

    public CharacterSheet() {
    }

    public CharacterSheet(String characterName, Long maxHp, Long currentHp, Long exp) {
        this.characterName = characterName;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CharacterSheet))
            return false;
        CharacterSheet that = (CharacterSheet) o;
        return getId ().equals (that.getId ()) &&
                getCharacterName ().equals (that.getCharacterName ()) &&
                getMaxHp ().equals (that.getMaxHp ()) &&
                getCurrentHp ().equals (that.getCurrentHp ()) &&
                getExp().equals (that.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getCharacterName (), getMaxHp (), getCurrentHp (), getExp());
    }
}
