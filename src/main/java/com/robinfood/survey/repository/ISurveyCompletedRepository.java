package com.robinfood.survey.repository;

import com.robinfood.survey.model.entity.SurveyCompleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISurveyCompletedRepository extends JpaRepository<SurveyCompleted, Long> {
}
