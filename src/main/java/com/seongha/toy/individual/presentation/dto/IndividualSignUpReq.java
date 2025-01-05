package com.seongha.toy.individual.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "개인 회원 가입 Request")
public record IndividualSignUpReq(

    @Schema(description = "이름", example = "홍길동")
    String name,

    @Schema(description = "이메일", example = "hongildong@gmail.com")
    String email,

    @Schema(description = "전화번호", example = "010-1234-5678")
    String phoneNumber
) {
}
