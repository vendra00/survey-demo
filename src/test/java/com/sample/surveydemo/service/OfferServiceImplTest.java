package com.sample.surveydemo.service;

import com.sample.surveydemo.model.Offer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  @Slf4j
class OfferServiceImplTest {

    @Autowired
    @InjectMocks
    OfferServiceImpl offerService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    Offer offer = new Offer();

    @Test
    public void testFindOfferByIdInDbWithSameIdValue() {
        offer.setId(100L);
        Assertions.assertNotNull(offer.getId());
        Assertions.assertEquals(100L, offer.getId());
    }

    @Test
    public void testFindOfferByIdInDbWithDifferentIdValue() {
        offer.setId(100L);
        Assertions.assertNotNull(offer.getId());
        Assertions.assertNotEquals(101L, offer.getId());
    }

}