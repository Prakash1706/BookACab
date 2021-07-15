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
import com.example.demo.entity.Employee;
import com.example.demo.entity.Source;
import com.example.demo.entity.TimeSlot;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.DestinationRepository;
import com.example.demo.repository.EmployeeRepository;
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
//			@Autowired
//			EmployeeRepository empRepo;
//			
//			
//			
//			@Override
//			public void run(String... args) throws Exception {
//				
////				Employee employee = new Employee(2034, "Prakash D", "Prakash.d@avasoft.com", 9876543210l, 0, 0, "Development(JAVA)", "Arvinth", "Cab Application", "Rohit", null, null, null, null, 0, null);
////				
////				empRepo.save(employee);
////			
////				BookingRequest request = new BookingRequest(1,2034,"Prakash D","BayLine","Tambaram","Bharath university",LocalDateTime.now(),LocalTime.of(10, 30),0,0,null,null,null,null,null,null,null,null,null,0);
////				this.bookingRepo.save(request);
////				
////				
////				DropPoint drop1 = new DropPoint(1, "Sholingnallur");
////				DropPoint drop2 = new DropPoint(2, "water Tank");
////				DropPoint drop3 = new DropPoint(3, "VGP");
////				DropPoint drop4 = new DropPoint(4, "Neelangari");
////				DropPoint drop5 = new DropPoint(5, "Paalavakkam");
////				DropPoint drop6 = new DropPoint(6, "Thiruvanmiyur");
////				DropPoint drop7 = new DropPoint(7, "Kelambakkam");
////				List<DropPoint> dropPoints = new ArrayList<>();
////				dropPoints.add(drop1);
////				dropPoints.add(drop2);
////				dropPoints.add(drop3);
////				dropPoints.add(drop4);
////				dropPoints.add(drop5);
////				dropPoints.add(drop6);
////				dropPoints.add(drop7);
////				
////				TimeSlot slot1 = new TimeSlot(1, LocalTime.of(19, 30));
////				TimeSlot slot2 = new TimeSlot(2, LocalTime.of(20, 30));
////				TimeSlot slot3 = new TimeSlot(3, LocalTime.of(21, 30));
////				TimeSlot slot4 = new TimeSlot(4, LocalTime.of(22, 30));
////				TimeSlot slot5 = new TimeSlot(5, LocalTime.of(23, 30));
////				TimeSlot slot6 = new TimeSlot(6, LocalTime.of(00, 30));
////				TimeSlot slot7 = new TimeSlot(7, LocalTime.of(2, 00));
////				List<TimeSlot> timeSlots = new ArrayList<>();
////				timeSlots.add(slot1);
////				timeSlots.add(slot2);
////				timeSlots.add(slot3);
////				timeSlots.add(slot4);
////				timeSlots.add(slot5);
////				timeSlots.add(slot6);
////				timeSlots.add(slot7);
////				
////				Destination destination = new Destination(4, "Thiruvanmiyur",dropPoints,timeSlots);
////				this.destinationRepo.save(destination);
////				
////				
////				Source source1 = new Source(1, "BayLine");
////				Source source2 = new Source(2, "AlphaCity");
////				this.sourceRepo.saveAll(Arrays.asList(source1,source2));
//			}
//		};
//	}
}
