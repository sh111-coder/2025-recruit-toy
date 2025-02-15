package com.seongha.toy.individual.mapper;

import com.seongha.toy.individual.domain.Individual;
import com.seongha.toy.individual.presentation.dto.IndividualSignUpReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IndividualMapper {

    @Mapping(ignore = true, target = "id")
    Individual toEntity(IndividualSignUpReq req);
}
