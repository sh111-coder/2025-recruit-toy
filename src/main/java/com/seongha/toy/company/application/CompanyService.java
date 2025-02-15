package com.seongha.toy.company.application;

import com.seongha.toy.common.dto.IdResponse;
import com.seongha.toy.company.mapper.CompanyMapper;
import com.seongha.toy.company.persistence.CompanyRepository;
import com.seongha.toy.company.presentation.dto.CompanySignUpReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Transactional
    public IdResponse signUp(CompanySignUpReq req) {
        var entity = companyMapper.toEntity(req);
        var savedEntity = companyRepository.save(entity);

        return new IdResponse(savedEntity.getId());
    }
}
