package com.sample.surveydemo.model.dto.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionDto {
    private Map<String, RegionData> regionData;
}
