package com.seongha.toy.jobposting.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공고 수정 Request")
public record JobPostingEditReq(

    @Schema(description = "제목", example = "[A 컴퍼니] 백엔드 개발자 채용")
    String title,

    @Schema(description = "이메일", example = "경력 3년 이상, Java & Spring 백엔드 개발자 채용합니다.")
    String content,

    @Schema(description = "기업 회원 ID", example = "0JDDZK5GND8VS")
    String companyId,

    @Schema(description = "게재 기간 DTO")
    PostingPeriodDto postingPeriod
) {
}
