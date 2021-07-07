package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {

	@Id
	int employeeId;
	String employeeName;
	String employeeMail;
	long phoneNumber;
	int isAdmin;
	int isBlocked;
	String domain;
	String domainLead;
	String projectName;
	String projectLead;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	int isDeleted;
	LocalDate blockedDate;
}
