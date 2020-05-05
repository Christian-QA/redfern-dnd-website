package com.qa.dnd.repo;

import com.qa.dnd.domain.ProficiencySheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencySheetRepository extends JpaRepository<ProficiencySheet, Long> {

}