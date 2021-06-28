package com.example.demo.dl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.Source;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.repository.SourceRepository;

@Service(value = "bookingService")
public class BookingDL {

	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private DestinationRepository destinationRepo;
	
	@Autowired
	private SourceRepository sourceRepo;
	
	//For getting Booking request
	public List<BookingRequest> getBookingRequests()
	{	
		return this.bookingRepo.findAll();
	}
	
	//For storing incoming Booking Request
	public BookingRequest storeBookingRequest(BookingRequest request) throws Exception
	{
		request.setBookingId(bookingRepo.count()+1);
		request.setBookingTime(LocalTime.now());
		
		if(request.getBookingTime().plusMinutes(20).isAfter(request.getTimeSlot())) {
			
			return null;
		}
		
		request.setStatus("pending");
		
		BookingRequest booking =  this.bookingRepo.save(request);
		
		if(booking == null) {
			throw new Exception();
		}
		
		return booking;
		
	}
	
	//For fetching all the destinations
	public List<Destination> fetchDestinationDetails()
	{
		List<Destination> destinations = this.destinationRepo.findAll();
		
		if(destinations.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return destinations;
		
	}
	
	//For fetching all the sources
	public List<Source> fetchSourceDetails()
	{
		List<Source> sources = this.sourceRepo.findAll();
		
		if(sources.isEmpty()) {
			throw new NoSuchElementException();
		}
		return sources;
	}
	
	//For Canceling the Ride
	public BookingRequest cancelTheRide(long bookingId)
	{
		Optional<BookingRequest> found = this.bookingRepo.findById(bookingId);
		
		BookingRequest cancelReq = null;
		
		if(found.isPresent())
		{	
			cancelReq = found.get();
		
			if(cancelReq.getStatus().equals("Assigned")) {
				
				return null;
			}
			
			cancelReq.setStatus("cancelled");
		}
		
		return this.bookingRepo.save(cancelReq);
		
	}
	
	
	//For validating Whether the user has already booked or not
	public BookingRequest validateBooking(int employeeId)
	{
		return this.bookingRepo.findBookingRequestByEmployeeId(employeeId);
		
	}
	
	
}
