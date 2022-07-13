package com.sample.surveydemo.model.dto.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sample.surveydemo.model.dto.region.RegionData;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionMapper {
    Map<String, RegionData> regions;
}
