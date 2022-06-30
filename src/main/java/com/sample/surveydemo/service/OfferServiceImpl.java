package com.sample.surveydemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.OfferMapper;
import com.sample.surveydemo.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class OfferServiceImpl implements OfferService{

    private static final String PARTNER_ID = "panthera";
    private static final String API_KEY = "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d";
    public static final String GET_ALL_OFFERS_API = "https://" + PARTNER_ID + ".api.hasoffers.com/Apiv3/json?api_key=" + API_KEY + "&Target=Affiliate_Offer&Method=findAll";
    private static final ObjectMapper mapper = new ObjectMapper();

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
    public ResponseEntity<Offer> findAllOffersApi2() {
        log.info("Find All Offers From Api2 - Service Call");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(GET_ALL_OFFERS_API, HttpMethod.GET, entity, Offer.class);
    }

    @Override
    public List<Offer> saveAllOffers(List<Offer> list) {
        log.info("Save All Offers - Service Call");
        return repository.saveAll(list);
    }

    @Override
    public List<String> processOfferDataFromObjectArray() {
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(GET_ALL_OFFERS_API, Object[].class);
        Object[] objects = responseEntity.getBody();
        assert objects != null;
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Offer.class))
                .map(Offer::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> processOfferDataFromOfferArray() {
        ResponseEntity<Offer[]> responseEntity = restTemplate.getForEntity(GET_ALL_OFFERS_API, Offer[].class);
        Offer[] offerArray = responseEntity.getBody();
        assert offerArray != null;
        return Arrays.stream(offerArray)
                .map(Offer::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> processOfferDataFromUserList() {
        ResponseEntity<List<Offer>> responseEntity =
                restTemplate.exchange(
                        GET_ALL_OFFERS_API,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        List<Offer> offers = responseEntity.getBody();
        assert offers != null;
        return offers.stream()
                .map(Offer::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> processNestedOfferDataFromUserArray() {
        return null;
    }

    @Override
    public List<String> processNestedOfferDataFromUserList() {
        return null;
    }
}
