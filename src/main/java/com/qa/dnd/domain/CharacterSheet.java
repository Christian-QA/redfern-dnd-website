package com.qa.dnd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String class_name;
    private Long max_hp;
    private Long current_hp;
    private int hit_dice;
    private int level;
    private int speed;
    private int initiative;
    private String weapon_training;
    private String armour_training;

    public void setId(Long id) {
        this.id = id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setMax_hp(Long max_hp) {
        this.max_hp = max_hp;
    }

    public void setCurrent_hp(Long current_hp) {
        this.current_hp = current_hp;
    }

    public void setHit_dice(int hit_dice) {
        this.hit_dice = hit_dice;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setWeapon_training(String weapon_training) {
        this.weapon_training = weapon_training;
    }

    public void setArmour_training(String armour_training) {
        this.armour_training = armour_training;
    }

    public Long getId() {
        return id;
    }

    public String getClass_name() {
        return class_name;
    }

    public Long getMax_hp() {
        return max_hp;
    }

    public Long getCurrent_hp() {
        return current_hp;
    }

    public int getHit_dice() {
        return hit_dice;
    }

    public int getLevel() {
        return level;
    }

    public int getSpeed() {
        return speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public String getWeapon_training() {
        return weapon_training;
    }

    public String getArmour_training() {
        return armour_training;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterSheet)) return false;
        CharacterSheet that = (CharacterSheet) o;
        return getHit_dice () == that.getHit_dice () &&
                getLevel () == that.getLevel () &&
                getSpeed () == that.getSpeed () &&
                getInitiative () == that.getInitiative () &&
                getId ().equals (that.getId ()) &&
                getClass_name ().equals (that.getClass_name ()) &&
                getMax_hp ().equals (that.getMax_hp ()) &&
                getCurrent_hp ().equals (that.getCurrent_hp ()) &&
                getWeapon_training ().equals (that.getWeapon_training ()) &&
                getArmour_training ().equals (that.getArmour_training ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getClass_name (), getMax_hp (), getCurrent_hp (), getHit_dice (), getLevel (), getSpeed (), getInitiative (), getWeapon_training (), getArmour_training ());
    }
}
