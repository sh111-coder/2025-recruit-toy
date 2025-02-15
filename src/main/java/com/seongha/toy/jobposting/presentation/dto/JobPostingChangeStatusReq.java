package com.seongha.toy.jobposting.presentation.dto;

import com.seongha.toy.jobposting.domain.PostingStatus;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "공고 상태 변경 Request")
public record JobPostingChangeStatusReq(

    @Schema(description = "기업 회원 ID", example = "0JDDZK5GND8VS")
    String companyId,

    @Schema(description = "변경할 공고 상태", example = "CLOSED")
    PostingStatus postingStatus
) {
}
