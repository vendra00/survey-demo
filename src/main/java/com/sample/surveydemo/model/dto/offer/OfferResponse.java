package com.sample.surveydemo.model.dto.offer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferResponse {
    @JsonProperty("status")
    private int status;
    @JsonProperty("httpStatus")
    private int httpStatus;
    @JsonProperty("data")
    private Map<String, OfferData> data;
}
