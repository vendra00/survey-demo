package com.sample.surveydemo.controller;

import com.sample.surveydemo.model.SurveyUser;
import com.sample.surveydemo.model.dto.user.SurveyUserDto;
import com.sample.surveydemo.service.SurveyUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/survey-users")
public class SurveyUserController {

    private final SurveyUserService service;

    public SurveyUserController(SurveyUserService service) {
        this.service = service;
    }

    @GetMapping("/find-all-survey-users")
    public ResponseEntity<Collection<SurveyUser>> getAllSuperHeroes()  {
        return ResponseEntity.ok(service.getAllSurveyUsers());
    }

    @GetMapping("/find-all-survey-users-dto")
    public ResponseEntity<Collection<SurveyUserDto>> getAllSuperHeroesDto()  {
        return ResponseEntity.ok(service.getAllSurveyUsersDto());
    }

    @PostMapping({ "/insert-survey-user/" })
    public ResponseEntity<SurveyUser> addSurveyUser(@RequestBody SurveyUser newUser)  {
            SurveyUser userBody = service.createSurveyUser(newUser);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBody.getId()).toUri();
            return ResponseEntity.created(location).build();
    }
}
