package com.example.demo.bl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dl.BookingDL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.Source;

@Component
public class BookingBL {
	
	@Autowired
	private BookingDL bookingDl;
	
	//For getting Booking request
	public List<BookingRequest> getBookingRequests()
	{
		return this.bookingDl.getBookingRequests();
	}
	
	//For storing incoming Booking Request
	public BookingRequest storeBookingRequest(BookingRequest request) throws Exception
	{
		BookingRequest bookingMade = this.bookingDl.storeBookingRequest(request);
		
		 return bookingMade;
	}
	
	//For fetching all the destinations
	public List<Destination> fetchDestinationDetails()
	{
		List<Destination> destinations = this.bookingDl.fetchDestinationDetails();	
		
		if(destinations.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return destinations;
	}
	
	//For fetching all the sources
	public List<Source> fetchSourceDetails()
	{
		List<Source> sources = this.bookingDl.fetchSourceDetails();	
		
		if(sources.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return sources;
	}
	
	//For Canceling the Ride
	public BookingRequest cancelTheRide(long bookingId)
	{
		return this.bookingDl.cancelTheRide(bookingId);
		
	}
	
	//For validating Whether the user has already booked or not
	public BookingRequest validateBooking(int employeeId) throws Exception
	{
		
		if(employeeId==0) {
			throw new Exception("Invalid employeeId");
		}
		
		return this.bookingDl.validateBooking(employeeId);
		
	}

}
