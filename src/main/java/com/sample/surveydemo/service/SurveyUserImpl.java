package com.sample.surveydemo.service;

import com.sample.surveydemo.exception.SurveyUserRequestException;
import com.sample.surveydemo.model.SurveyUser;
import com.sample.surveydemo.model.dto.SurveyUserDto;
import com.sample.surveydemo.repository.SurveyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @Slf4j
public class SurveyUserImpl implements SurveyUserService {

    private final SurveyUserRepository repository;

    private static final String PARTNER_ID = "panthera";
    private static final String API_KEY = "5a69f5fe6ce2bac3cc3d698987e92455154560d35838cf8466f8fcf184b1360d";
    private static final String GET_ALL_OFFERS_API = "https://" + PARTNER_ID + ".api.hasoffers.com/Apiv3/json?api_key=" + API_KEY + "&Target=Affiliate_Offer&Method=findAll";

    @Autowired
    private RestTemplate restTemplate;

    public SurveyUserImpl(SurveyUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SurveyUser> findAllSurveyUsers(String stringFilter) {
        log.info("Get All Users With Filter - Service Call");
        try {
            if (stringFilter == null || stringFilter.isEmpty()) {
                return getAllSurveyUsers();
            } else {
                return repository.search(stringFilter);
            }
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when fetching all users with filter");
        }
    }

    @Override
    public List<SurveyUser> getAllSurveyUsers() {
        log.info("Get All Users - Service Call");
        try {
            //chegar os dados
            //https://test.api.hasoffers.com/Apiv3/json?api_key=test&Target=Affiliate_AffiliateUser&Method=findAll

            //filtrar de acordo com o que quiser

            //retornar lista filtrada
            return repository.findAll();
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when fetching all users");
        }
    }

    @Override
    public List<SurveyUserDto> getAllSurveyUsersDto() {
        log.info("Get All Users DTO - Service Call");
        try {
            return repository.findAll().stream().map(this::convertToSuperHeroDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when fetching all users with dto");
        }
    }

    @Override
    public Optional<SurveyUser> getSurveyUserByName(String name) {
        return Optional.empty();
    }

    @Override
    public SurveyUser createSurveyUser(SurveyUser surveyUser) {
        log.info("Create New User - Service Call");
        try {
            repository.save(surveyUser);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when creating this user");
        }

        return surveyUser;
    }

    @Override
    public void deleteSurveyUser(SurveyUser surveyUser) {
        log.info("Delete User - Service Call");
        try {
            repository.delete(surveyUser);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when deleting this User");
        }
    }

    @Override
    public long countSurveyUsers() {
        log.info("Count Users - Service Call");
        try {
            return repository.count();
        } catch (Exception e) {
            log.error("ERROR : " + e);
            throw new SurveyUserRequestException("There was a problem when counting users");
        }
    }

    private SurveyUserDto convertToSuperHeroDto(SurveyUser entity) {
        SurveyUserDto dto = new SurveyUserDto();
        dto.setFirstName(entity.getFirstName());
        return dto;
    }
}
