package com.seongha.toy.jobposting.mapper;

import com.seongha.toy.jobposting.domain.JobPosting;
import com.seongha.toy.jobposting.presentation.dto.JobPostingEditReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingPostReq;
import com.seongha.toy.jobposting.presentation.dto.JobPostingRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface JobPostingMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "companyId")
    @Mapping(ignore = true, target = "postingStatus")
    JobPosting toEntity(JobPostingPostReq req);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "companyId")
    @Mapping(ignore = true, target = "postingStatus")
    JobPosting toEntity(JobPostingEditReq req);

    JobPostingRes toRes(JobPosting entity);
}
