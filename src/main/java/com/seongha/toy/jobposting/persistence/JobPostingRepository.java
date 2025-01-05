package com.seongha.toy.jobposting.persistence;

import com.seongha.toy.jobposting.domain.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, String> {
}
