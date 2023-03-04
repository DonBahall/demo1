package com.example.demo.Repository;

import com.example.demo.Model.PepModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PepRepository extends MongoRepository<PepModel, String> {
    Optional<PepModel> findPepModelByFullName(String fullName);
}