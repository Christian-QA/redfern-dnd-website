package com.qa.dnd.service;

import com.qa.dnd.domain.CharacterSheet;
import com.qa.dnd.exceptions.CharacterNotFoundException;
import com.qa.dnd.repo.CharacterSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSheetService {

    private final CharacterSheetRepository repo;

    @Autowired
    public CharacterSheetService(CharacterSheetRepository repo) {
        this.repo = repo;
    }

    public List<CharacterSheet> readCharacterSheet() {
        return this.repo.findAll();
    }

    public CharacterSheet createCharacter(CharacterSheet character) {
        return this.repo.save(character);
    }

    public CharacterSheet findCharacterById(Long id) {
        return this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
    }

    public CharacterSheet updateCharacter(Long id, CharacterSheet character) {
        CharacterSheet update = findCharacterById(id);
        update.setClass_name(character.getClass_name());
        update.setMax_hp(character.getMax_hp());
        update.setCurrent_hp(character.getCurrent_hp());
        update.setHit_dice(character.getHit_dice());
        update.setLevel(character.getLevel());
        update.setSpeed(character.getSpeed());
        update.setInitiative(character.getInitiative());
        update.setWeapon_training(character.getWeapon_training());
        update.setArmour_training(character.getArmour_training());
        return this.repo.save(update);
    }

    public boolean deleteCharacter(Long id) {
        if (!this.repo.existsById(id)) {
            throw new CharacterNotFoundException ();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
