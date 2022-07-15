package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferService {

    /**
     * Method that will get all the offers from API
     * @return List of full Offers
     */
    ResponseEntity<OfferMapper> findAllOffersApi();

    /**
     * Method that receives a list of Offers only and save in the Database.
     * @param list List of Offers
     */
    void saveAllOffers(List<Offer> list);

}
