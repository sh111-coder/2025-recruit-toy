package com.seongha.toy.jobposting.presentation;

import com.seongha.toy.common.dto.EmptyResponse;
import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.jobposting.application.JobPostingService;
import com.seongha.toy.jobposting.presentation.dto.JobPostingChangeStatusReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingEditReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingPostReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "공고 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/job-postings")
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @Operation(summary = "공고 게재")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse post(@RequestBody JobPostingPostReq req) {
        return jobPostingService.post(req);
    }

    @Operation(summary = "공고 수정")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse edit(@PathVariable String id, @RequestBody JobPostingEditReq req) {
        return jobPostingService.edit(id, req);
    }

    @Operation(summary = "공고 상태 변경")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse changeStatus(@PathVariable String id, @RequestBody JobPostingChangeStatusReq req) {
        return jobPostingService.changeStatus(id, req);
    }

    @Operation(summary = "공고 조회")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobPostingRes get(@PathVariable String id) {
        return jobPostingService.get(id);
    }
}
