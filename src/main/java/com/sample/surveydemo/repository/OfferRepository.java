package com.sample.surveydemo.repository;

import com.sample.surveydemo.model.SurveyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<SurveyUser, UUID> {
}
