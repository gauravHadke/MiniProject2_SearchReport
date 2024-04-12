package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REPORT_MASTER")
public class ReportDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "REPORT_ID")
	private Integer reportId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MOBILE")
	private Long mobile;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "GENDER")
	private Character gender;
	
	@Column(name = "SSN")
	private Integer ssn;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_DATE" , updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "UPDATED_DATE" , insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	

}
