package com.seongha.toy.apply.persistence;

import com.seongha.toy.apply.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, String> {
}
