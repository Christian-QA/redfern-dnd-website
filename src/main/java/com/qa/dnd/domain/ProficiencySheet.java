package com.qa.dnd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ProficiencySheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean acrobatics;
    private boolean animal_handling;
    private boolean arcana;
    private boolean athletics;
    private boolean deception;
    private boolean history;
    private boolean insight;
    private boolean intimidation;
    private boolean investigation;
    private boolean medicine;
    private boolean nature;
    private boolean perception;
    private boolean performance;
    private boolean persuasion;
    private boolean religion;
    private boolean sleight_of_hand;
    private boolean stealth;
    private boolean survival;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAcrobatics(boolean acrobatics) {
        this.acrobatics = acrobatics;
    }

    public void setAnimal_handling(boolean animal_handling) {
        this.animal_handling = animal_handling;
    }

    public void setArcana(boolean arcana) {
        this.arcana = arcana;
    }

    public void setAthletics(boolean athletics) {
        this.athletics = athletics;
    }

    public void setDeception(boolean deception) {
        this.deception = deception;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public void setInsight(boolean insight) {
        this.insight = insight;
    }

    public void setIntimidation(boolean intimidation) {
        this.intimidation = intimidation;
    }

    public void setInvestigation(boolean investigation) {
        this.investigation = investigation;
    }

    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public void setPerception(boolean perception) {
        this.perception = perception;
    }

    public void setPerformance(boolean performance) {
        this.performance = performance;
    }

    public void setPersuasion(boolean persuasion) {
        this.persuasion = persuasion;
    }

    public void setReligion(boolean religion) {
        this.religion = religion;
    }

    public void setSleight_of_hand(boolean sleight_of_hand) {
        this.sleight_of_hand = sleight_of_hand;
    }

    public void setStealth(boolean stealth) {
        this.stealth = stealth;
    }

    public void setSurvival(boolean survival) {
        this.survival = survival;
    }

    public Long getId() {
        return id;
    }

    public boolean isAcrobatics() {
        return acrobatics;
    }

    public boolean isAnimal_handling() {
        return animal_handling;
    }

    public boolean isArcana() {
        return arcana;
    }

    public boolean isAthletics() {
        return athletics;
    }

    public boolean isDeception() {
        return deception;
    }

    public boolean isHistory() {
        return history;
    }

    public boolean isInsight() {
        return insight;
    }

    public boolean isIntimidation() {
        return intimidation;
    }

    public boolean isInvestigation() {
        return investigation;
    }

    public boolean isMedicine() {
        return medicine;
    }

    public boolean isNature() {
        return nature;
    }

    public boolean isPerception() {
        return perception;
    }

    public boolean isPerformance() {
        return performance;
    }

    public boolean isPersuasion() {
        return persuasion;
    }

    public boolean isReligion() {
        return religion;
    }

    public boolean isSleight_of_hand() {
        return sleight_of_hand;
    }

    public boolean isStealth() {
        return stealth;
    }

    public boolean isSurvival() {
        return survival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProficiencySheet))
            return false;
        ProficiencySheet that = (ProficiencySheet) o;
        return isAcrobatics () == that.isAcrobatics () &&
                isAnimal_handling () == that.isAnimal_handling () &&
                isArcana () == that.isArcana () &&
                isAthletics () == that.isAthletics () &&
                isDeception () == that.isDeception () &&
                isHistory () == that.isHistory () &&
                isInsight () == that.isInsight () &&
                isIntimidation () == that.isIntimidation () &&
                isInvestigation () == that.isInvestigation () &&
                isMedicine () == that.isMedicine () &&
                isNature () == that.isNature () &&
                isPerception () == that.isPerception () &&
                isPerformance () == that.isPerformance () &&
                isPersuasion () == that.isPersuasion () &&
                isReligion () == that.isReligion () &&
                isSleight_of_hand () == that.isSleight_of_hand () &&
                isStealth () == that.isStealth () &&
                isSurvival () == that.isSurvival () &&
                getId ().equals (that.getId ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), isAcrobatics (), isAnimal_handling (), isArcana (), isAthletics (), isDeception (), isHistory (), isInsight (), isIntimidation (), isInvestigation (), isMedicine (), isNature (), isPerception (), isPerformance (), isPersuasion (), isReligion (), isSleight_of_hand (), isStealth (), isSurvival ());
    }
}
