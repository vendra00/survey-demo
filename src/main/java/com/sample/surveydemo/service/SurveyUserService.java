package com.sample.surveydemo.service;

import com.sample.surveydemo.model.SurveyUser;
import com.sample.surveydemo.model.dto.SurveyUserDto;

import java.util.List;
import java.util.Optional;

public interface SurveyUserService {

    List<SurveyUser> findAllSurveyUsers(String stringFilter);

    List<SurveyUser> getAllSurveyUsers();

    List<SurveyUserDto> getAllSurveyUsersDto();

    Optional<SurveyUser> getSurveyUserByName(String name);

    SurveyUser createSurveyUser(SurveyUser surveyUser);

    void deleteSurveyUser(SurveyUser surveyUser);

    long countSurveyUsers();

}
