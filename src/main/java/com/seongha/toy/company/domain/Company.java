package com.seongha.toy.company.domain;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(schema = "member", name = "company")
public class Company {

    @Id
    @Tsid
    @Column(name = "id")
    private String id;

    @Column(name = "identification_number")
    @Setter
    private String identificationNumber;

    @Column(name = "name")
    @Setter
    private String name;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "contact")
    @Setter
    private String contact;
}
