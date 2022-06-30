package com.sample.surveydemo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferRequest {

    private String target;
    private String format;
    private String service;
    private String version;
    private String api_key;
    private String method;
    private List<String> contains;

}
