package com.sample.surveydemo.repository;

import com.sample.surveydemo.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query(value = "select o from Offer o join o.countries c where c.code = 'AU' or c.code = 'SG'")
    List<Offer> searchByCountryCode();
}
