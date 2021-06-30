package com.example.demo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DropPoint;
import com.example.demo.entity.Source;
import com.example.demo.entity.TimeSlot;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.repository.SourceRepository;

@SpringBootApplication
public class BookACabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookACabApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner runner()
//	{
//		return new CommandLineRunner() {
//			
//			@Autowired
//			BookingRepository bookingRepo;
//			
//			@Autowired
//			DestinationRepository destinationRepo;
//			
//			@Autowired
//			SourceRepository sourceRepo;
//			
//			
//			
//			@Override
//			public void run(String... args) throws Exception {
//			
////				BookingRequest request = new BookingRequest(1,2034,"Prakash D","BayLine","Tambaram","Bharath university",LocalDateTime.now(),LocalTime.of(10, 30),0,0,null,null,null,null,null,null,null,null,null,0);
////				this.bookingRepo.save(request);
//				
//				
//				DropPoint drop1 = new DropPoint(1, "Padur");
//				DropPoint drop2 = new DropPoint(2, "Marina Mall");
//				List<DropPoint> dropPoints = new ArrayList<>();
//				dropPoints.add(drop1);
//				dropPoints.add(drop2);
//				
//				TimeSlot slot1 = new TimeSlot(1, LocalTime.of(8, 30));
//				TimeSlot slot2 = new TimeSlot(2, LocalTime.of(10, 30));
//				TimeSlot slot3 = new TimeSlot(3, LocalTime.of(22, 30));
//				TimeSlot slot4 = new TimeSlot(4, LocalTime.of(00, 30));
//				List<TimeSlot> timeSlots = new ArrayList<>();
//				timeSlots.add(slot1);
//				timeSlots.add(slot2);
//				timeSlots.add(slot3);
//				timeSlots.add(slot4);
//				
//				Destination destination = new Destination(3, "Kelambakkam",dropPoints,timeSlots);
//				this.destinationRepo.save(destination);
//				
//				
////				Source source1 = new Source(1, "BayLine");
////				Source source2 = new Source(2, "AlphaCity");
////				this.sourceRepo.saveAll(Arrays.asList(source1,source2));
//				
//				
////				Employee mark = new Employee(2039, "Mark Anto", "mark@abc.com", 9876543210L, 0, 0, "Java", "Arvinth", "AvaCab", "Rohit", null, null, null, null, 0);
////				
////				this.empRepo.save(mark);
//				
//			}
//		};
//	}

}
