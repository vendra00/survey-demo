package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.OfferMapper;
import com.sample.surveydemo.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service @Slf4j
public class OfferServiceImpl implements OfferService{

    private static final String PARTNER_ID = "panthera";
    private static final String API_KEY = "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d";
    public static final String GET_ALL_OFFERS_API = "https://" + PARTNER_ID + ".api.hasoffers.com/Apiv3/json?api_key=" + API_KEY + "&Target=Affiliate_Offer&Method=findAll";

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
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(GET_ALL_OFFERS_API, HttpMethod.GET, entity, OfferMapper.class);
    }

    @Override
    public List<Offer> saveAllOffers(List<Offer> list) {
        log.info("Save All Offers - Service Call");
        return repository.saveAll(list);
    }
}
