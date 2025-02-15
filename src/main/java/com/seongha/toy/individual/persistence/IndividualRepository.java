package com.seongha.toy.individual.persistence;

import com.seongha.toy.individual.domain.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, String> {
}
