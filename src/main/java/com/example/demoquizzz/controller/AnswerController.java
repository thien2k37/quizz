package com.example.demoquizzz.controller;

import com.example.demoquizzz.model.Answer;
import com.example.demoquizzz.service.answer.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    IAnswerService answerService;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> findAll() {
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Answer>> findById(@PathVariable long id) {
        return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity create(@RequestBody Answer answer) {
        answerService.save(answer);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Answer>> update(@PathVariable long id, @RequestBody Answer answer) {
        Optional<Answer> answer1 = answerService.findById(id);
        if (!answer1.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        answer.setId(answer1.get().getId());
        answerService.save(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Iterable<Answer>> findAllByQuestionId(@PathVariable Long id) {
        return new ResponseEntity<>(answerService.findAllByQuestionId(id), HttpStatus.OK);
    }
}
