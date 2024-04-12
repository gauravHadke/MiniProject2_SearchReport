package com.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entity.ReportDetail;
import com.example.repo.ReportRepo;

@Component
public class AppRunner implements ApplicationRunner{
	
	@Autowired
	private ReportRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		ReportDetail entity1 = new ReportDetail();
		entity1.setReportId(1);
		entity1.setName("gaurav");
		entity1.setEmail("gaurav@gmail.com");
		entity1.setMobile(987654421L);
		entity1.setGender('M');
		entity1.setSsn(8768762);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");
		
		repo.save(entity1);
		
		ReportDetail entity2 = new ReportDetail();
		entity2.setReportId(2);
		entity2.setName("darshan");
		entity2.setEmail("darshan@gmail.com");
		entity2.setMobile(997654421L);
		entity2.setGender('M');
		entity2.setSsn(9768762);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		
		repo.save(entity2);
		
		ReportDetail entity3 = new ReportDetail();
		entity3.setReportId(3);
		entity3.setName("shreyas");
		entity3.setEmail("shreyas@gmail.com");
		entity3.setMobile(327654421L);
		entity3.setGender('M');
		entity3.setSsn(6768762);
		entity3.setPlanName("MEDICADE");
		entity3.setPlanStatus("Closed");
		
		repo.save(entity3);
	}

}

