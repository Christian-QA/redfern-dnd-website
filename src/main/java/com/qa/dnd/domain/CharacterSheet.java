package com.qa.dnd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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



}
