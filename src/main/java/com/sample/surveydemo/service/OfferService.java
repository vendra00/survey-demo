package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferService {
    ResponseEntity<OfferMapper> findAllOffersApi();

    void saveAllOffers(List<Offer> list);

}
