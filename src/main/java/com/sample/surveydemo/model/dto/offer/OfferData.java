package com.sample.surveydemo.model.dto.offer;

import com.fasterxml.jackson.annotation.*;
import com.sample.surveydemo.model.dto.country.CountryData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class OfferData {
    @JsonProperty("Offer")
    private OfferDto offer;
    @JsonProperty("Country")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Map<String,CountryData>> country;
}
