package com.seongha.toy.jobposting.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;

@Schema(description = "공고 게재 기간 DTO")
public record PostingPeriodDto(

    @Schema(description = "게재 시작 기간", example = "2025-01-05T00:00:00Z")
    Instant start,

    @Schema(description = "게재 종료 기간", example = "2025-01-12T00:00:00Z")
    Instant end
) {
}
