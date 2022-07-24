package com.sample.surveydemo.controller;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import com.sample.surveydemo.service.OfferService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api
@RestController
@RequestMapping("/offer")
public class OfferController {
    private final OfferService service;

    @Autowired
    public OfferController(OfferService service) {
        this.service = service;
    }

    @Cacheable(value = "listAllOffersFromApi")
    @GetMapping("/find-all-offers-api")
    public ResponseEntity<OfferMapper> findAllOffersApi() {
        log.info("Find All Offers From Api - Controller Call");
        return ResponseEntity.ok().body(service.findAllOffersApi().getBody());
    }

    @Cacheable(value = "listAllOffersFromApi")
    @GetMapping("/find-offer-by-id-db/{id}")
    public ResponseEntity<Offer> findAllOffersApi(@PathVariable("id") Long id) {
        log.info("Find Offer By ID Database - Controller Call");
        return ResponseEntity.ok().body(service.findOfferById(id).orElseThrow());
    }

    @GetMapping("/find-all-offers-paged-db/{offset}/{pageSize}")
    public ResponseEntity<Page<Offer>> findAllOffersPagedDb(@PathVariable int offset, @PathVariable int pageSize) {
        log.info("Find All Offers Paged From Database - Controller Call");
        return ResponseEntity.ok().body(service.findAllOffersPagedDb(offset, pageSize));
    }

    @GetMapping("/find-all-offers-db/")
    public ResponseEntity<List<Offer>> findAllOffersDb() {
        log.info("Find All Offers From Database - Controller Call");
        return ResponseEntity.ok().body(service.findAllOffersDb());
    }

    @GetMapping("/find-all-offers-by-country-code-db/")
    public ResponseEntity<List<Offer>> findAllByCountryCode() {
        log.info("Find All Offers By Country Code From Database - Controller Call");
        return ResponseEntity.ok().body(service.findAllByCountryCode());
    }
}
