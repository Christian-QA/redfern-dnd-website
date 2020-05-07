package com.qa.dnd.domain;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    private Long id;

    private String SkillName;

    @OneToOne
    @MapsId
    private CharacterSheet characterSheet;




}
