package com.example.demoquizzz.service.quetion;

import com.example.demoquizzz.model.Question;
import com.example.demoquizzz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionService implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Iterable<Question> findAllByContentContaining(String content) {
        return questionRepository.findAllByContentContaining(content);
    }
}
