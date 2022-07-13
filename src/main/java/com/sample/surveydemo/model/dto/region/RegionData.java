package com.sample.surveydemo.model.dto.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionData {
    @JsonProperty("id")
    private String id;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_code_3c")
    private String countryCode3c;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
}
