//Zugriff auf MongoDB
package com.example.stami_be.repository;

import com.example.stami_be.model.Transaktion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransaktionRepository extends MongoRepository<Transaktion, String> {
}