package com.sample.surveydemo.service;

import com.sample.surveydemo.exception.OfferRequestException;
import com.sample.surveydemo.model.Country;
import com.sample.surveydemo.model.Offer;
import com.sample.surveydemo.model.dto.country.CountryData;
import com.sample.surveydemo.model.dto.offer.OfferData;
import com.sample.surveydemo.model.dto.offer.OfferMapper;
import com.sample.surveydemo.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService {

    private static final String PARTNER_ID = "panthera";
    private static final String API_KEY = "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d";
    private static final String API_VERSION = "Apiv3";
    private static final String TARGET = "Affiliate_Offer";
    private static final String METHOD = "findAll&contain[]=Country";
    public static final String GET_ALL_OFFERS_API = "https://" + PARTNER_ID + ".api.hasoffers.com/" + API_VERSION + "/json?api_key=" + API_KEY + "&Target=" + TARGET + "&Method=" + METHOD;

    private final OfferRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public OfferServiceImpl(OfferRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    /**
     * Method that get all offers and parse them to POJOs and make it able to be manipulated in JAVA.
     * @return response from the API as a mapped JSON
     */
    @Override
    public ResponseEntity<OfferMapper> findAllOffersApi() {
        log.info("Find All Offers From Api - Service Call");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            ResponseEntity<OfferMapper> response = restTemplate.exchange(GET_ALL_OFFERS_API, HttpMethod.GET, entity, OfferMapper.class);
            processAndSaveOffers(response);
            return response;
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when fetching all offers");
        }
    }

    /**
     * Method that will receive and save a list of Offers in our Database.
     * @param list List of Offers.
     */
    @Override
    public void saveAllOffers(List<Offer> list) {
        log.info("Save All Offers In DB- Service Call");
        try {
            repository.saveAll(list);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when saving all offers in database");
        }

    }

    /**
     * Method that will get an Offer by ID in our Database.
     * @param id id passed by the UI;
     * @return a checked optional Offer.
     */
    @Override
    public Optional<Offer> findOfferById(Long id) {
        log.info("Find Offer By ID In The Database - Service Call");
        Optional<Offer> offer = repository.findById(id);
        if (offer.isPresent()) {
            return offer;
        } else {
            throw new OfferRequestException("There is no offer with ID: " + id + " in database");
        }
    }

    /**
     * Method that returns a list of offers with pagination.
     * @param offSet page number value.
     * @param pageSize page size value.
     * @return list pageable offers.
     */
    @Override
    public Page<Offer> findAllOffersPagedDb(int offSet, int pageSize) {
        log.info("Find All Offer Paged In The Database - Service Call");
        try{
            return repository.findAll(PageRequest.of(offSet,pageSize));
        }catch (Exception e){
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when fetching the offers in database");
        }
    }

    /**
     * Method that return a list of offers from database.
     * @return list of offers.
     */
    @Override
    public List<Offer> findAllOffersDb() {
        log.info("Find All Offer In The Database - Service Call");
        try{
            return repository.findAll();
        }catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when fetching the offers in database");
        }
    }

    /**
     * Method that will get all offers filtered by country code 'AU' and 'SG
     * @return list of offers
     */
    @Override
    public List<Offer> findAllByCountryCode() {
        log.info("Find All Offer By Country Code In The Database - Service Call");
        try{
            return repository.searchByCountryCode();
        }catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when fetching the offers by country code in database");
        }
    }

    /**
     * Method responsible to process and save all the full Offers as list of Offers Objects.
     * @param response a list of parsed full offers from a JSON archive.
     */
    private void processAndSaveOffers(ResponseEntity<OfferMapper> response) {
        log.info("Process And Save Offers - Service Call");
        Map<String, OfferData> map;
        List<Offer> offers = new ArrayList<>();
        try {
            map = Objects.requireNonNull(response.getBody()).getResponse().getData();
            for (OfferData mapper : map.values()) {
                Offer offer = new Offer();
                OfferDtoToOfferConverter(mapper, offer);
                offers.add(offer);

            }
            saveAllOffers(offers);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when processing all offers in database");
        }
    }


    private void OfferDtoToOfferConverter(OfferData mapper, Offer offer) {
        log.debug("OfferDto To Offer Converter - Service Call");

        List<Country> countries = new ArrayList<>();
        List<Map<String, CountryData>> map;
        map = Objects.requireNonNull(mapper.getCountry());

        try{

            offer.setAllowWebsiteLinks(mapper.getOffer().isAllowWebsiteLinks());
            offer.setAllowMultipleConversions(mapper.getOffer().getAllowMultipleConversions());
            offer.setApprovalStatus(mapper.getOffer().getApprovalStatus());
            offer.setCurrency(mapper.getOffer().getCurrency());
            offer.setConversionCap(mapper.getOffer().getConversionCap());
            offer.setDescription(mapper.getOffer().getDescription());
            offer.setDefaultGoalName(mapper.getOffer().getDefaultGoalName());
            offer.setDefaultPayout(mapper.getOffer().getDefaultPayout());
            offer.setDneDownloadUrl(mapper.getOffer().getDneDownloadUrl());
            offer.setDneListId(mapper.getOffer().getDneListId());
            offer.setDneThirdPartyList(mapper.getOffer().isDneThirdPartyList());
            offer.setDneUnsubscribeUrl(mapper.getOffer().getDneUnsubscribeUrl());
            offer.setEmailInstructions(mapper.getOffer().isEmailInstructions());
            offer.setEmailInstructionsSubject(mapper.getOffer().getEmailInstructionsSubject());
            offer.setEmailInstructionsFrom(mapper.getOffer().getEmailInstructionsFrom());
            offer.setEnforceSecureTrackingLink(mapper.getOffer().getEnforceSecureTrackingLink());
            offer.setExpirationDate(mapper.getOffer().getExpirationDate());
            offer.setExpired(mapper.getOffer().isExpired());
            offer.setFeatured(mapper.getOffer().getFeatured());
            offer.setHasGoalsEnabled(mapper.getOffer().isHasGoalsEnabled());
            offer.setLinkPlatform(mapper.getOffer().getLinkPlatform());
            offer.setModified(mapper.getOffer().getModified());
            offer.setMonthlyConversionCap(mapper.getOffer().getMonthlyConversionCap());
            offer.setMonthlyPayoutCap(mapper.getOffer().getMonthlyPayoutCap());
            offer.setName(mapper.getOffer().getName());
            offer.setPayoutCap(mapper.getOffer().getPayoutCap());
            offer.setPayoutType(mapper.getOffer().getPayoutType());
            offer.setPercentPayout(mapper.getOffer().getPercentPayout());
            offer.setPreviewUrl(mapper.getOffer().getPreviewUrl());
            offer.setProtocol(mapper.getOffer().getProtocol());
            offer.setRequireApproval(mapper.getOffer().isRequireApproval());
            offer.setRequireTermsConditions(mapper.getOffer().getRequireTermsConditions());
            offer.setSessionHours(mapper.getOffer().getSessionHours());
            offer.setShowCustomVariables(mapper.getOffer().isShowCustomVariables());
            offer.setShowMailList(mapper.getOffer().isShowMailList());
            offer.setStatus(mapper.getOffer().getStatus());
            offer.setUsePayoutGroups(mapper.getOffer().getUsePayoutGroups());
            offer.setUseTargetRules(mapper.getOffer().isUseTargetRules());

            //Get country values to be mapped into a list
            for (Map<String, CountryData> countryDataMap: map) {
                for (CountryData countryData: countryDataMap.values()) {
                    Country country = new Country();
                    country.setName(countryData.getName());
                    country.setCode(countryData.getCode());
                    countries.add(country);
                    offer.setCountries(countries);
                }
            }

        }catch (Exception e){
            log.error("ERROR : " + e);
            throw new OfferRequestException("There was a problem when converting a offerDto to Offer");
        }
    }
}
