package com.qa.dnd.service;

import com.qa.dnd.domain.ProficiencySheet;
import com.qa.dnd.exceptions.ProficienciesNotFoundException;
import com.qa.dnd.repo.ProficiencySheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficiencySheetService {

    private final ProficiencySheetRepository repo;

    @Autowired
    public ProficiencySheetService(ProficiencySheetRepository repo) {
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
        ProficiencySheet update = findProficiencySheetById(id);
        update.setAcrobatics(proficiencies.isAcrobatics());
        update.setAnimal_handling(proficiencies.isAnimal_handling());
        update.setArcana(proficiencies.isArcana());
        update.setAthletics(proficiencies.isAthletics());
        update.setDeception(proficiencies.isDeception());
        update.setHistory(proficiencies.isHistory());
        update.setInsight(proficiencies.isInsight());
        update.setIntimidation(proficiencies.isIntimidation());
        update.setInvestigation(proficiencies.isInvestigation());
        update.setMedicine(proficiencies.isMedicine());
        update.setNature(proficiencies.isNature());
        update.setPerception(proficiencies.isPerception());
        update.setPerformance(proficiencies.isPerformance());
        update.setPersuasion(proficiencies.isPersuasion());
        update.setReligion(proficiencies.isReligion());
        update.setSleight_of_hand(proficiencies.isSleight_of_hand());
        update.setStealth(proficiencies.isStealth());
        update.setSurvival(proficiencies.isSurvival());

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
