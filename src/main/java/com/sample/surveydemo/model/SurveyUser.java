package com.sample.surveydemo.model;

import com.sample.surveydemo.model.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity @Getter @Setter
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
