package com.seongha.toy.individual.presentation;

import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.individual.application.IndividualService;
import com.seongha.toy.individual.presentation.dto.IndividualSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "개인 회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/individuals")
public class IndividualController {

    private final IndividualService individualService;

    @Operation(summary = "회원가입")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse signUp(@RequestBody IndividualSignUpReq req) {
        return individualService.signUp(req);
    }
}
