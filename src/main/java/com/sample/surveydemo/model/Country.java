package com.sample.surveydemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COUNTRY_TBL")
@Entity(name = "Country")
public class Country extends AbstractEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
