package com.example.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.req.RequestReport;
import com.example.res.ResponceReport;
import com.example.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/plan")
	public ResponseEntity<List<String>> uniquePlanName(){
		List<String> planNames = service.getPlanNames();
		return new ResponseEntity<>(planNames,HttpStatus.OK);
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<String>> uniquePlanStatus(){
		List<String> planStatus = service.getPlanStatus();
		return new ResponseEntity<>(planStatus,HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<ResponceReport>> search(@RequestBody RequestReport req){
		List<ResponceReport> search = service.search(req);
		return new ResponseEntity<>(search,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void getExcelSheet(HttpServletResponse res) throws IOException {
		
		res.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename = data.xls";
		
		res.setHeader(headerKey, headerValue);
		
		service.excel(res); 
	}
	
}
