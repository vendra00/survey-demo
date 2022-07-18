package com.sample.surveydemo.controller;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import com.sample.surveydemo.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/offer")
public class OfferController {
    private final OfferService service;

    @Autowired
    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping("/find-all-offers-api")
    public ResponseEntity<OfferMapper> findAllOffersApi() {
        log.info("Find All Offers From Api - Controller Call");
        return service.findAllOffersApi();
    }

    @GetMapping("/find-offer-by-id-db/{id}")
    public ResponseEntity<Offer> findAllOffersApi(@PathVariable("id") Long id) {
        log.info("Find Offer By ID Database - Controller Call");
        Optional<Offer> offer = service.findOfferById(id);
        return ResponseEntity.ok().body(offer.orElseThrow());
    }

}
