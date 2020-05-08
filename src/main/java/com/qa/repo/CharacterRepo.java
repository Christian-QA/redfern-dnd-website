package com.qa.repo;

import com.qa.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Long> {
}
