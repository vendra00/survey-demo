package com.sample.surveydemo.model.dto.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CountryMapper {

    @JsonProperty("Country")
    private Map<String, CountryData> countries;
}
