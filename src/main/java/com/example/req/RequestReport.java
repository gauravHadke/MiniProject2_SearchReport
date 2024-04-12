package com.example.req;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestReport {
	
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	

}
