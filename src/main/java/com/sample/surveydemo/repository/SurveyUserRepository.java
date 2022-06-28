package com.sample.surveydemo.repository;

import com.sample.surveydemo.model.SurveyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SurveyUserRepository extends JpaRepository<SurveyUser, UUID> {

    @Query("select user from SurveyUser user "
            + "where lower(user.firstName) like lower(concat('%', :searchTerm, '%')) OR lower(user.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<SurveyUser> search(@Param("searchTerm") String searchTerm);
}
