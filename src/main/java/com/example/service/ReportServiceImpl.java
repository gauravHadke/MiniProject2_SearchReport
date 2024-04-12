package com.example.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.ReportDetail;
import com.example.repo.ReportRepo;
import com.example.req.RequestReport;
import com.example.res.ResponceReport;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportRepo reportRepo;

	@Override
	public List<String> getPlanNames() {
		return reportRepo.findPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return reportRepo.findPlanStatus();
	}

	@Override
	public List<ResponceReport> search(RequestReport req) {
		
		ArrayList<ResponceReport> responseObjList = new ArrayList<>();
		
		ReportDetail quaryBuilder = new ReportDetail();
		
		String planName = req.getPlanName();
		if(planName!=null && !planName.equals("")) {
			quaryBuilder.setPlanName(planName);
		}
		
		String planStatus = req.getPlanStatus();
		if(planStatus!=null && !planStatus.equals("")) {
			quaryBuilder.setPlanStatus(planStatus);
		}
		
		LocalDate planStartDate = req.getPlanStartDate();
		if(planStartDate!=null) {
			quaryBuilder.setPlanStartDate(planStartDate);
		}
		
		LocalDate planEndDate = req.getPlanEndDate();
		if(planEndDate!=null) {
			quaryBuilder.setPlanStartDate(planEndDate);
		}
		
		Example<ReportDetail> example = Example.of(quaryBuilder);
		
		List<ReportDetail> entities = reportRepo.findAll(example);
		
		for(ReportDetail entity : entities) {
			ResponceReport resReport = new ResponceReport();
			BeanUtils.copyProperties(entity, resReport);
			responseObjList.add(resReport);
		}
		
		
		return responseObjList;
	}

	
	@Override
	public void excel(HttpServletResponse res) throws IOException {
		// TODO Auto-generated method stub
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet();
		HSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("NAME");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("MOBILE");
		headerRow.createCell(3).setCellValue("GENDER");
		headerRow.createCell(4).setCellValue("SSN");
		
		ServletOutputStream outputStream = res.getOutputStream();
		hssfWorkbook.write(outputStream);
		hssfWorkbook.close();
		outputStream.close();
		
	}

	@Override
	public void pdf(HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

}
