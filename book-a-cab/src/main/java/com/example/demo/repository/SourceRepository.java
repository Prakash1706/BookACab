package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Source;

public interface SourceRepository extends MongoRepository<Source, Integer> {

}
