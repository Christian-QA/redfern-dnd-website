package com.qa.repo;

import com.qa.domain.Abilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepo extends JpaRepository<Abilities, Long> {
}
