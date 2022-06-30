package com.sample.surveydemo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sample.surveydemo.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferObject {
    Offer offer;
}
