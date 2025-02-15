package com.seongha.toy.apply.application;

import com.seongha.toy.apply.mapper.ApplyMapper;
import com.seongha.toy.apply.persistence.ApplyRepository;
import com.seongha.toy.apply.presentation.dto.ApplyChangeStatusReq;
import com.seongha.toy.apply.presentation.dto.ApplyCreateReq;
import com.seongha.toy.apply.presentation.dto.ApplyRes;
import com.seongha.toy.individual.persistence.IndividualRepository;
import com.seongha.toy.jobposting.persistence.JobPostingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplyService {

    private final ApplyRepository applyRepository;
    private final ApplyMapper applyMapper;

    private final JobPostingRepository jobPostingRepository;
    private final IndividualRepository individualRepository;

    public void apply(ApplyCreateReq req) {
        var apply = applyMapper.toEntity(req);
        var jobPostingId = req.jobPostingId();
        var applicantId = req.applicantId();
        validateExist(jobPostingId, applicantId);

        apply.applyStart(jobPostingId, applicantId);

        applyRepository.save(apply);
    }

    private void validateExist(String jobPostingId, String applicantId) {
        var isExistJobPosting = jobPostingRepository.existsById(jobPostingId);
        var isExistApplicant = individualRepository.existsById(applicantId);

        if (!isExistJobPosting) {
            throw new IllegalArgumentException("존재하지 않는 공고입니다.");
        }
        if (!isExistApplicant) {
            throw new IllegalArgumentException("존재하지 않는 지원자입니다.");
        }
    }

    public void changeStatus(ApplyChangeStatusReq req, String applyId) {
        var apply = applyRepository.findById(applyId).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 지원입니다."));
        apply.changeStatus(req.status());
    }

    public ApplyRes get(String applyId) {
        var apply = applyRepository.findById(applyId).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 지원입니다."));
        return applyMapper.toRes(apply);
    }
}
