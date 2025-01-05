package com.seongha.toy.jobposting.application;

import com.seongha.toy.common.dto.EmptyResponse;
import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.company.persistence.CompanyRepository;
import com.seongha.toy.jobposting.mapper.JobPostingMapper;
import com.seongha.toy.jobposting.persistence.JobPostingRepository;
import com.seongha.toy.jobposting.presentation.dto.JobPostingChangeStatusReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingEditReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingPostReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingRes;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final CompanyRepository companyRepository;

    private final JobPostingMapper jobPostingMapper;

    @Transactional
    public IdResponse post(JobPostingPostReq req) {
        var jobPosting = jobPostingMapper.toEntity(req);
        var company = companyRepository.findById(req.companyId()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 기업입니다."));

        jobPosting.postStart(company);
        var savedJobPosting = jobPostingRepository.save(jobPosting);

        return new IdResponse(savedJobPosting.getId());
    }

    @Transactional
    public EmptyResponse edit(String id, JobPostingEditReq req) {
        var jobPosting = jobPostingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공고입니다."));
        var company = companyRepository.findById(req.companyId()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 기업입니다."));
        jobPosting.validateOwner(company);

        var jobPostingToEdit = jobPostingMapper.toEntity(req);
        jobPosting.edit(jobPostingToEdit);

        return new EmptyResponse();
    }

    @Transactional
    public EmptyResponse changeStatus(String id, JobPostingChangeStatusReq req) {
        var jobPosting = jobPostingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공고입니다."));
        var company = companyRepository.findById(req.companyId()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 기업입니다."));
        jobPosting.validateOwner(company);

        jobPosting.changeStatus(req.postingStatus());
        return new EmptyResponse();
    }

    public JobPostingRes get(String id) {
        var jobPosting = jobPostingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공고입니다."));

        return jobPostingMapper.toRes(jobPosting);
    }
}
