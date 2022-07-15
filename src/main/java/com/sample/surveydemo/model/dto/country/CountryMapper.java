package com.sample.surveydemo.model.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryMapper {
    private Map<String, CountryData> countries;
}
