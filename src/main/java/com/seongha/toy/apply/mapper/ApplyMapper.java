package com.seongha.toy.apply.mapper;

import com.seongha.toy.apply.domain.Apply;
import com.seongha.toy.apply.presentation.dto.ApplyCreateReq;
import com.seongha.toy.apply.presentation.dto.ApplyRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ApplyMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "jobPostingId")
    @Mapping(ignore = true, target = "applicantId")
    @Mapping(ignore = true, target = "applicationStatus")
    Apply toEntity(ApplyCreateReq req);

    ApplyRes toRes(Apply apply);
}
