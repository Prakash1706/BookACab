package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bl.BookingBL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.Source;
import com.example.demo.repository.BookingRepository;
import com.example.demo.status.CustomStatus;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/user/booking/")
public class BookingController {
	
	@Autowired
	private BookingBL bookingBl;
	
	//For getting Booking request
	@GetMapping(path = "/bookings")
	public ResponseEntity<List<BookingRequest>> getBookings()
	{
		List<BookingRequest> requests = this.bookingBl.getBookingRequests();
		
		return ResponseEntity.status(HttpStatus.OK).body(requests);
	}

	//For storing BookingRequest
	@PostMapping(path = "/bookacab")
	public ResponseEntity<BookingRequest> storeBookingrequest(@RequestBody BookingRequest request) throws Exception
	{
		BookingRequest savedRequest = this.bookingBl.storeBookingRequest(request);
		
		if(savedRequest == null) {
			
			return ResponseEntity.status(CustomStatus.TIMEOUT).body(null);
		}
		
				
		return ResponseEntity.status(HttpStatus.OK).body(savedRequest);
	}
	
	//For fetching all the destinations
	@GetMapping(path = "/destinations")
	public ResponseEntity<List<Destination>> fetchDestinationDetails()
	{
		List<Destination> destinations = this.bookingBl.fetchDestinationDetails();
		
		return ResponseEntity.status(HttpStatus.OK).body(destinations);
	}
	
	//For fetching all the sources
	@GetMapping(path = "/sources")
	public ResponseEntity<List<Source>> fetchSourceDetails()
	{
		List<Source> sources = this.bookingBl.fetchSourceDetails();
		
		return ResponseEntity.status(HttpStatus.OK).body(sources);
		
	}
	
	//For Canceling the Ride
	@PutMapping(path = "/cancel/{id}")
	public ResponseEntity<BookingRequest> cancelTheRide(@PathVariable("id") long bookingId)
	{
		BookingRequest canceledReq = this.bookingBl.cancelTheRide(bookingId);
		
		if(canceledReq==null) {
			return ResponseEntity.status(CustomStatus.INPROGRESS).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(canceledReq);
		
	}
	
	
	//For validating Whether the user has already booked or not
	@GetMapping(path = "/validate/{id}")
	public ResponseEntity<BookingRequest> validateBooking(@PathVariable("id") int employeeId) throws Exception
	{
		
		BookingRequest request = this.bookingBl.validateBooking(employeeId);
		if(request!=null) 
		{
			if(request.getStatus().equals("pending"))
			{
				return ResponseEntity.status(CustomStatus.PENDING).body(request);
			}
			else if(request.getStatus().equals("ongoing") || request.getStatus().equals("Assigned"))
			{
				return ResponseEntity.status(CustomStatus.INPROGRESS).body(null);
			}
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(request);
	}
	@Autowired
	BookingRepository repo;
	
	@GetMapping(path = "/filters")
	public List<BookingRequest> filter(@RequestBody BookingRequest book)
	{
		//Criteria c = Criteria.where(getBookingTime()).alike(Example.of(book));
		return this.repo.findAll(Example.of(book));
	}
	
	@GetMapping(path = "/time")
	public String getBookingTime()
	{
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
	}
		
	
}
