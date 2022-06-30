package com.sample.surveydemo.controller;

import com.sample.surveydemo.model.dto.OfferMapper;
import com.sample.surveydemo.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.sample.surveydemo.service.OfferServiceImpl.GET_ALL_OFFERS_API;

@Slf4j
@RestController
@RequestMapping("/offer")
public class OfferController {

    private final OfferService service;
    private final RestTemplate restTemplate;

    @Autowired
    public OfferController(OfferService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/find-all-offers-api")
    public ResponseEntity<OfferMapper> findAllOffersApi() {
        log.info("Find All Offers From Api - Controller Call");
       return service.findAllOffersApi();
    }

    @GetMapping("/find-all-offers-api2")
    public ResponseEntity<OfferMapper> getAllOffersApi2()  {
            return service.findAllOffersApi();
    }

    @GetMapping("/test")
    public OfferMapper getApi() {
        OfferMapper offerUrl = restTemplate.getForObject(GET_ALL_OFFERS_API, OfferMapper.class);
        assert offerUrl != null;
        log.info("Offer: " + offerUrl);

        return offerUrl;
    }

    @GetMapping("/test2")
    public List<String> getApi2() {
        List<String> test = service.processOfferDataFromOfferArray();
        for (String s : test) {
            log.info("Sou: " + s);
        }
        return test;
    }
}
