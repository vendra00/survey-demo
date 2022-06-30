package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.OfferMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferService {
    ResponseEntity<OfferMapper> findAllOffersApi();

    List<Offer> saveAllOffers(List<Offer> list);

}
