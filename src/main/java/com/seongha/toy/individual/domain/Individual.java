package com.seongha.toy.individual.domain;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@Table(schema = "member", name = "individual")
public class Individual {

    @Id
    @Tsid
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    @Setter
    private String name;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "phone_number")
    @Setter
    private String phoneNumber;
}
