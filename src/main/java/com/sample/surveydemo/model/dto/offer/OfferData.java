package com.sample.surveydemo.model.dto.offer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.surveydemo.model.dto.country.CountryMapper;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferData {
    @JsonProperty("Offer")
    private OfferDto offer;

    //@JsonProperty("Country")
    private CountryMapper country;
}
