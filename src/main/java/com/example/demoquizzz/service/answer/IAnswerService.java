package com.example.demoquizzz.service.answer;


import com.example.demoquizzz.model.Answer;
import com.example.demoquizzz.service.IService;
import org.springframework.data.repository.query.Param;

public interface IAnswerService extends IService<Answer> {
    Iterable<Answer> findAllByQuestionId(@Param("id") Long id);
}
