package com.seongha.toy.apply.domain;

import com.seongha.toy.common.audit.BaseAuditEntity;
import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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

    private String jobPostingId;

    private String applicantId;

    @Enumerated(EnumType.STRING)
    @Setter
    private ApplicationStatus applicationStatus;

    public void applyStart(String jobPostingId, String individualId) {
        this.jobPostingId = jobPostingId;
        this.applicantId = individualId;
        this.applicationStatus = ApplicationStatus.WAITING;
    }

    public void changeStatus(String applicationStatus) {
        this.applicationStatus = ApplicationStatus.find(applicationStatus);
    }
}
