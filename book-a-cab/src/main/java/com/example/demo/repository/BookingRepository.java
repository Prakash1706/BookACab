package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.*;

import com.example.demo.entity.BookingRequest;

public interface BookingRepository extends MongoRepository<BookingRequest, Long> {

	
	@Query(value = "{employeeId:?0 , status:{$nin:[null , cancelled , reached , noshow ]}}")
	BookingRequest findBookingRequestByEmployeeId(int id);
}
