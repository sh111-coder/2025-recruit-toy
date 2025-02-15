package com.seongha.toy.jobposting.domain;

import com.seongha.toy.common.audit.BaseAuditEntity;
import com.seongha.toy.company.domain.Company;
import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(schema = "recruit", name = "job_posting")
public class JobPosting extends BaseAuditEntity {

    @Id
    @Tsid
    @Column(name = "id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Company company;

    @Setter
    private String title;

    @Setter
    private String content;

    @AttributeOverrides({
        @AttributeOverride(name = "start", column = @Column(name = "posting_period_start")),
        @AttributeOverride(name = "end", column = @Column(name = "posting_period_end")),
    })
    @Setter
    private PostingPeriodVo postingPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name = "posting_status")
    @Setter
    private PostingStatus postingStatus;

    public void postStart(Company company) {
        this.company = company;
        this.postingStatus = PostingStatus.OPEN;
    }

    public void edit(JobPosting jobPostToEdit) {
        this.title = jobPostToEdit.title;
        this.content = jobPostToEdit.content;
        this.postingPeriod = jobPostToEdit.postingPeriod;
    }

    public void validateOwner(Company company) {
        if (!Objects.equals(this.company.getId(), company.getId())) {
            throw new IllegalArgumentException("공고를 게재한 기업 회원이 아닙니다.");
        }
    }

    public void changeStatus(PostingStatus postingStatus) {
        this.postingStatus = postingStatus;
    }
}
