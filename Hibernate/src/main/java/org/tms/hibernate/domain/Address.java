package org.tms.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Enumerated(EnumType.STRING)
    private City city;
    private String street;
}