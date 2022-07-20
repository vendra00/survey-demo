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
@Table(name = "REGION_TBL")
@Entity(name = "Region")
public class Region extends AbstractEntity{
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_code_3c")
    private String countryCode3c;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
