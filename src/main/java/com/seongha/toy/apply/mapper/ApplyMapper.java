package com.seongha.toy.apply.mapper;

import com.seongha.toy.apply.domain.Apply;
import com.seongha.toy.apply.presentation.dto.ApplyCreateReq;
import com.seongha.toy.apply.presentation.dto.ApplyRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ApplyMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "jobPosting")
    @Mapping(ignore = true, target = "applicant")
    Apply toEntity(ApplyCreateReq req);

    @Mapping(source = "jobPosting.id", target = "jobPostingId")
    @Mapping(source = "applicant.id", target = "applicantId")
    ApplyRes toRes(Apply apply);
}
