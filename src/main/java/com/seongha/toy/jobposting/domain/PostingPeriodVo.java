package com.seongha.toy.jobposting.domain;

import jakarta.persistence.Embeddable;
import java.time.Instant;

@Embeddable
public record PostingPeriodVo(
    Instant start,
    Instant end
) {
}
