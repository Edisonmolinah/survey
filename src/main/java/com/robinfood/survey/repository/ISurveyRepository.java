package com.robinfood.survey.repository;

import com.robinfood.survey.model.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISurveyRepository extends JpaRepository<Survey, Long> {
}
