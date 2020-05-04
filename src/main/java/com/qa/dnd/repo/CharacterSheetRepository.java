package com.qa.dnd.repo;

import com.qa.dnd.domain.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {

    CharacterSheet findByTitle(String title);

}