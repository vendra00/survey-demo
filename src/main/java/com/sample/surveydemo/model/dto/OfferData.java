package com.sample.surveydemo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sample.surveydemo.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferData {
    Offer offer;
}
