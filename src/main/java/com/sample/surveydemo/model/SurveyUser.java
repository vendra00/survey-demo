package com.sample.surveydemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SURVEY_USER_TBL")
@Entity(name = "SurveyUser")
public class SurveyUser extends AbstractEntity {

    @NotEmpty(message = "first name is required")
    private String firstName;

    @NotEmpty(message = "last name is required")
    private String lastName;

    @NotEmpty(message = "email is required")
    private String email;

    @NotEmpty(message = "gender is required")
    private String gender;

    @NotEmpty(message = "date of birth is required")
    private String birthDate;

}
