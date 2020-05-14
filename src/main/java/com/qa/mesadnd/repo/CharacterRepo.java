package com.qa.mesadnd.repo;

import com.qa.mesadnd.domain.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterSheet, Long> {
}
