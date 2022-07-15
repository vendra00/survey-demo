package com.sample.surveydemo.service;

import com.sample.surveydemo.exception.OfferRequestException;
import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.offer.OfferData;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import com.sample.surveydemo.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service @Slf4j
public class OfferServiceImpl implements OfferService{

    private static final String PARTNER_ID = "panthera";
    private static final String API_KEY = "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d";
    private static final String API_VERSION = "Apiv3";
    private static final String TARGET = "Affiliate_Offer";
    private static final String METHOD = "findAll&contain[]=Country";
    public static final String GET_ALL_OFFERS_API = "https://" + PARTNER_ID + ".api.hasoffers.com/"+ API_VERSION + "/json?api_key=" + API_KEY + "&Target=" + TARGET + "&Method="+ METHOD;

    private final OfferRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public OfferServiceImpl(OfferRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<OfferMapper> findAllOffersApi() {
        log.info("Find All Offers From Api - Service Call");
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            //mapper(entity.getBody().toString());
            ResponseEntity<OfferMapper> response = restTemplate.exchange(GET_ALL_OFFERS_API, HttpMethod.GET, entity, OfferMapper.class);
            processAndSaveOffers(response);
            return response;
        }catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when fetching all offers");
        }
    }

    private void processAndSaveOffers(ResponseEntity<OfferMapper> response) {
        log.info("Process and save Offers - Service Call");
        Map<String, OfferData> map;
        List<Offer> list = new ArrayList<>();
        try{
            map = Objects.requireNonNull(response.getBody()).getResponse().getData();
            for (OfferData mapper : map.values()){
                list.add(mapper.getOffer());
            }
            saveAllOffers(list);
        }catch (Exception e){
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when processing all offers in database");
        }
    }

    @Override
    public void saveAllOffers(List<Offer> list) {
        log.info("Save All Offers - Service Call");
        try {
            repository.saveAll(list);
        }  catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when saving all offers in database");
        }

    }

}
