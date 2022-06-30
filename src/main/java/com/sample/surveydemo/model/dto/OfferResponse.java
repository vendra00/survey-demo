package com.sample.surveydemo.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferResponse {

    @JsonProperty("status")
    private int status;
    @JsonProperty("httpStatus")
    private int httpStatus;
    @JsonProperty("data")
    private OfferData data;
}
