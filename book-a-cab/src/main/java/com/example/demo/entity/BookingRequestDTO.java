package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequestDTO {

long bookingId;
	
	int employeeId;
	String employeeName;
	String source;
	String destination;
	String dropPoint;
	LocalTime bookingTime;
	LocalTime timeSlot;
	int addedManually;
	int tripCabId;
	LocalTime startTime;
	LocalTime reachedTime;
	String complaintDescription;
	String remarks;
	String status;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	int isDeleted;
	String slotDate;
	String bookingDate;
}
