package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

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

    /**
     * Method that will get an Offer by ID in our Database
     * @param id id passed by the UI;
     * @return an object of Optional Offer
     */
    Optional<Offer> findOfferById(Long id);

    /**
     * Method that will get all offers from the db with pagination
     * @param offSet page number value
     * @param pageSize page size value
     * @return return a list of offers
     */
    Page<Offer> findAllOffersPagedDb(int offSet, int pageSize);

    /**
     * Method that will get all offers from the db
     * @return list of offers
     */
    List<Offer> findAllOffersDb();

    /**
     * Method that will return all offers filtered by country code AU and SG
     * @return list of offers
     */
    List<Offer> findAllByCountryCode();

}
