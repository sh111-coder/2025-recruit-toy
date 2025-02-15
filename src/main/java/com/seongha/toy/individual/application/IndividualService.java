package com.seongha.toy.individual.application;

import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.individual.mapper.IndividualMapper;
import com.seongha.toy.individual.persistence.IndividualRepository;
import com.seongha.toy.individual.presentation.dto.IndividualSignUpReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndividualService {

    private final IndividualRepository individualRepository;
    private final IndividualMapper individualMapper;

    @Transactional
    public IdResponse signUp(IndividualSignUpReq req) {
        var entity = individualMapper.toEntity(req);
        var savedEntity = individualRepository.save(entity);

        return new IdResponse(savedEntity.getId());
    }
}
