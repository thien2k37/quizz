package com.example.demoquizzz.repository;

import com.example.demoquizzz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Iterable<Question> findAllByContentContaining(String content);
}
