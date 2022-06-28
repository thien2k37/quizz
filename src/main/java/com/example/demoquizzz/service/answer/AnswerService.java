package com.example.demoquizzz.service.answer;

import com.example.demoquizzz.model.Answer;
import com.example.demoquizzz.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AnswerService implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Page<Answer> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Iterable<Answer> findAllByQuestionId(Long id) {
        return answerRepository.findAllByQuestionId(id);
    }
}
