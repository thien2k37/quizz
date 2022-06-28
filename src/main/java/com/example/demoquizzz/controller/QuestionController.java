package com.example.demoquizzz.controller;

import com.example.demoquizzz.model.Question;
import com.example.demoquizzz.service.quetion.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAll() {
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity create(@RequestBody Question question) {
        questionService.save(question);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> findById(@PathVariable long id) {
        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Question>> update(@PathVariable long id, @RequestBody Question question) {
        Optional<Question> question1 = questionService.findById(id);
        if (!question1.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        question.setId(question1.get().getId());

        questionService.save(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search-by-content")
    public ResponseEntity<Iterable<Question>> findAllByNameContaining(@RequestParam String content) {
        return new ResponseEntity<>(questionService.findAllByContentContaining(content), HttpStatus.OK);
    }

}
