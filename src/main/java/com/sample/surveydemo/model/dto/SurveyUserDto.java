package com.sample.surveydemo.model.dto;

import com.sample.surveydemo.model.SurveyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SurveyUserDto {

    private String firstName;
    private String lastName;
    private String email;

    public SurveyUserDto (SurveyUser surveyUser) {
        this.firstName = surveyUser.getFirstName();
        this.lastName = surveyUser.getLastName();
        this.email = surveyUser.getEmail();
    }
}
