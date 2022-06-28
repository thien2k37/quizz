package com.example.demoquizzz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    void save(T t);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void remove(Long id);
    Page<T> findAllByNameContaining(Pageable pageable, String name);
}
