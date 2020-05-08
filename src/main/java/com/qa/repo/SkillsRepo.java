package com.qa.repo;

import com.qa.domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {
}
