package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ReportDetail;

@Repository
public interface ReportRepo extends  JpaRepository<ReportDetail, Integer>{

	@Query("select distinct(planName) from ReportDetail")
	public List<String> findPlanNames();
	
	@Query("select distinct(planStatus) from ReportDetail")
	public List<String> findPlanStatus();
	
}
