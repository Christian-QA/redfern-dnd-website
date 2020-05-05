package com.qa.dnd.repo;

import com.qa.dnd.domain.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyRepository extends JpaRepository<CharacterSheet, Long> {

}