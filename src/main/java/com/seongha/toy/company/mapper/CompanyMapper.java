package com.seongha.toy.company.mapper;

import com.seongha.toy.company.domain.Company;
import com.seongha.toy.company.presentation.dto.CompanySignUpReq;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company toEntity(CompanySignUpReq req);
}
