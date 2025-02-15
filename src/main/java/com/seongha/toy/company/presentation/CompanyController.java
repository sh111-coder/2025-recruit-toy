package com.seongha.toy.company.presentation;

import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.company.application.CompanyService;
import com.seongha.toy.company.presentation.dto.CompanySignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "기업 회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "회원가입")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse signUp(@RequestBody CompanySignUpReq req) {
        return companyService.signUp(req);
    }
}