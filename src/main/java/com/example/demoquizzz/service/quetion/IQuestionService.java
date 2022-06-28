package com.example.demoquizzz.service.quetion;

import com.example.demoquizzz.model.Question;
import com.example.demoquizzz.service.IService;

public interface IQuestionService extends IService<Question> {
    Iterable<Question> findAllByContentContaining(String content);
}
