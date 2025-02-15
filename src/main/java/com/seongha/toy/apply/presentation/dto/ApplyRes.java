package com.seongha.toy.apply.presentation.dto;

public record ApplyRes(
    String id,
    String jobPostingId,
    String applicantId,
    String applicationStatus,
    String createdAt,
    String updatedAt
) {
}
