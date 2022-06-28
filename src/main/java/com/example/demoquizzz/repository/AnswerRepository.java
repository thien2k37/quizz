package com.example.demoquizzz.repository;

import com.example.demoquizzz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "from Answer where question_id.id = :id")
    Iterable<Answer> findAllByQuestionId(@Param("id") Long id);
}
