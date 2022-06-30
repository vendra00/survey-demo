package com.sample.surveydemo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferRequest {

    @JsonProperty("Target")
    private String target;
    @JsonProperty("Format")
    private String format;
    @JsonProperty("Service")
    private String service;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("api_key")
    private String apiKey;
    @JsonProperty("Method")
    private String method;
    @JsonProperty("contain")
    private List<String> contain;

}
