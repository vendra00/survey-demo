package com.sample.surveydemo.service;

import com.sample.surveydemo.model.dto.offer.OfferMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
class OfferServiceImplTest {

    @Autowired
    @InjectMocks
    OfferServiceImpl offerService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testJasonCountry(){
        String json = """
                {
                    "request": {
                        "Target": "Affiliate_Offer",
                        "Format": "json",
                        "Service": "HasOffers",
                        "Version": "2",
                        "api_key": "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d",
                        "Method": "findAll",
                        "contain": [
                            "Country"
                        ]
                    },
                    "response": {
                        "status": 1,
                        "httpStatus": 200,
                        "data": {
                            "18292": {
                                "Offer": {
                                    "id": "18292",
                                    "name": "247 Profit Formula",
                                    "approval_status": "approved"
                                },
                                "Country":[]
                                }
                            }}}}""";

        ResponseEntity<OfferMapper> responseEntity = offerService.findAllOffersApi();
        Objects.requireNonNull(responseEntity.getBody()).getResponse().getData().values();
    }
}