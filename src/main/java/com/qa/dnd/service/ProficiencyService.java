package com.qa.dnd.service;

import com.qa.dnd.domain.ProficiencySheet;
import com.qa.dnd.exceptions.ProficienciesNotFoundException;
import com.qa.dnd.repo.ProficiencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficiencyService {

    private final ProficiencyRepository repo;

    @Autowired
    public ProficiencyService(ProficiencyRepository repo) {
        this.repo = repo;
    }

    public List<ProficiencySheet> readProficiencySheet() {
        return this.repo.findAll();
    }

    public ProficiencySheet createProficiencySheet(ProficiencySheet proficiencies) {
        return this.repo.save(proficiencies);
    }

    public ProficiencySheet findProficiencySheetById(Long id) {
        return this.repo.findById(id).orElseThrow(ProficienciesNotFoundException::new);
    }

    public ProficiencySheet updateProficiencySheet(Long id, ProficiencySheet proficiencies) {
        ProficiencySheet update = findCharacterSheetById(id);
        update.setCharacter_name(character.getCharacter_name());
        update.setClass_name(character.getClass_name());
        update.setMax_hp(character.getMax_hp());
        update.setCurrent_hp(character.getCurrent_hp());
        update.setHit_dice(character.getHit_dice());
        update.setLevel(character.getLevel());
        update.setSpeed(character.getSpeed());
        update.setWeapon_training(character.getWeapon_training());
        update.setArmour_training(character.getArmour_training());
        return this.repo.save(update);
    }

    public boolean deleteProficiency(Long id) {
        if (!this.repo.existsById(id)) {
            throw new ProficienciesNotFoundException ();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
