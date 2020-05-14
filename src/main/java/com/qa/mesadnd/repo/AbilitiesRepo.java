package com.qa.mesadnd.repo;

import com.qa.mesadnd.domain.Abilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepo extends JpaRepository<Abilities, Long> {
}
