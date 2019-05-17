package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Receiver;

@Repository
public interface ReceiverRepository extends MongoRepository<Receiver, String> {

	Receiver findByEmailAndMobileNumber(String email, String mobileNumber);

}
