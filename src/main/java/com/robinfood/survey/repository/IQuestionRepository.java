package com.robinfood.survey.repository;

import com.robinfood.survey.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {
}
