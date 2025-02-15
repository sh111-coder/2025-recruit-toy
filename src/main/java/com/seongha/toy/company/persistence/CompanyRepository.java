package com.seongha.toy.company.persistence;

import com.seongha.toy.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
