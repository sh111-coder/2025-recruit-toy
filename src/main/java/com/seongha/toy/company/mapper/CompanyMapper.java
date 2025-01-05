package com.seongha.toy.company.mapper;

import com.seongha.toy.company.domain.Company;
import com.seongha.toy.company.presentation.dto.CompanySignUpReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CompanyMapper {

    @Mapping(ignore = true, target = "id")
    Company toEntity(CompanySignUpReq req);
}
