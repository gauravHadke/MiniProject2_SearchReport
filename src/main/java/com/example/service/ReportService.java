package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.example.req.RequestReport;
import com.example.res.ResponceReport;

import jakarta.servlet.http.HttpServletResponse;

@Service
public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<ResponceReport> search(RequestReport req);
	
	public void excel(HttpServletResponse res) throws IOException;
	
	public void pdf(HttpServletResponse res);
	
}
