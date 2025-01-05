package com.seongha.toy.company.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "기업 회원 가입 Request")
public record CompanySignUpReq(

    @Schema(description = "사업자 번호", example = "123-45-67890")
    String identificationNumber,

    @Schema(description = "이름", example = "홍길동")
    String name,

    @Schema(description = "이메일", example = "hongildong@gmail.com")
    String email,

    @Schema(description = "기업 연락처", example = "02-1234-5678")
    String contact
) {
}
