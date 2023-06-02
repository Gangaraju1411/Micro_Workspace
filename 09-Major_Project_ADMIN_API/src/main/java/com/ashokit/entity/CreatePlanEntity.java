package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CreatePlanEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Plan Name")
	private String planName;
	
	@Column(name="Plan Start Date")
	private String startDate;
	
	@Column(name="Plan End Date")
	private String endDate;
	
	
	
	
	
}
