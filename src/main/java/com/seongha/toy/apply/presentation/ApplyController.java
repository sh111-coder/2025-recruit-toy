package com.seongha.toy.apply.presentation;

import com.seongha.toy.apply.application.ApplyService;
import com.seongha.toy.apply.presentation.dto.ApplyChangeStatusReq;
import com.seongha.toy.apply.presentation.dto.ApplyCreateReq;
import com.seongha.toy.apply.presentation.dto.ApplyRes;
import com.seongha.toy.common.dto.EmptyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "지원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/applies")
public class ApplyController {

    private final ApplyService applyService;

    @Operation(summary = "지원 API")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmptyResponse apply(@RequestBody ApplyCreateReq req) {
        applyService.apply(req);
        return new EmptyResponse();
    }

    @Operation(summary = "지원 상태 변경 API")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse changeStatus(@RequestBody ApplyChangeStatusReq req, String applyId) {
        applyService.changeStatus(req, applyId);
        return new EmptyResponse();
    }

    @Operation(summary = "지원 조회 API")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApplyRes get(String applyId) {
        return applyService.get(applyId);
    }
}
