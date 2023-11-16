package in.madhav.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import in.madhav.entity.CitizensPlan;
import in.madhav.request.SearchRequest;

public interface ReportService {

	public List<String> getplanNames();
	public List<String> getPlanStatus();
	public List<CitizensPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
