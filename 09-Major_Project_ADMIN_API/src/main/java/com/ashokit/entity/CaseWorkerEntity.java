package com.ashokit.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CaseWorkerEntity {

	@Id
	@GeneratedValue
	private Integer userId;
	
	@Column(name="Full Name")
	private String fullName;
	
	@Column(name="Email ID")
	private String email;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="Mobile Number")
	private Long number;
	
	@Column(name="Password")
	private String Pazzword;
	
	@Column(name="Role")
	private Integer role ;
	
	@Column(name="Status")
	private String status;
	
	
	
	
	
	
}
