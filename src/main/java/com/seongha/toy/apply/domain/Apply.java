package com.seongha.toy.apply.domain;

import com.seongha.toy.common.audit.BaseAuditEntity;
import com.seongha.toy.individual.domain.Individual;
import com.seongha.toy.jobposting.domain.JobPosting;
import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "recruit", name = "apply")
public class Apply extends BaseAuditEntity {

    @Id
    @Tsid
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Individual applicant;

    @Enumerated(EnumType.STRING)
    @Setter
    private ApplicationStatus applicationStatus;

    public void applyStart(JobPosting jobPosting, Individual individual) {
        this.jobPosting = jobPosting;
        this.applicant = individual;
        this.applicationStatus = ApplicationStatus.WAITING;
    }

    public void changeStatus(String applicationStatus) {
        this.applicationStatus = ApplicationStatus.find(applicationStatus);
    }
}
