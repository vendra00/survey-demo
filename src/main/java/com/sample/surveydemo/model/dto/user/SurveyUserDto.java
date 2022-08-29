package com.sample.surveydemo.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class SurveyUserDto {

    private String firstName;
    private String lastName;
    private String email;
}
