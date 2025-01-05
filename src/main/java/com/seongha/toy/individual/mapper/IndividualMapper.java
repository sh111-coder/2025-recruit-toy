package com.seongha.toy.individual.mapper;

import com.seongha.toy.individual.domain.Individual;
import com.seongha.toy.individual.presentation.dto.IndividualSignUpReq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualMapper {

    Individual toEntity(IndividualSignUpReq req);
}
