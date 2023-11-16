package in.madhav.service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.madhav.entity.CitizensPlan;
import in.madhav.repo.CitizenPlanRepository;
import in.madhav.request.SearchRequest;
import in.madhav.utils.EmailUtils;
import in.madhav.utils.ExcelGenerator;
import in.madhav.utils.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGnerator;
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getplanNames() {
		List<String> planNanes = repo.getPlanNanes();
		return planNanes;
	}
	
	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}
	
	
	@Override
	public List<CitizensPlan> search(SearchRequest request) {
		//copy binding object data into entity class
		CitizensPlan citizen=new CitizensPlan();
		//BeanUtils.copyProperties(request, citizen);
		//problem with copy like this , empty values will come in query 
		
		if(null!=request.getPlanName() &&! "".equals(request.getPlanName())) {
			citizen.setPlanName(request.getPlanName());
		}

		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			citizen.setPlanStatus(request.getPlanStatus());
		}

		if(null!=request.getGender() && !"".equals(request.getGender())) {
			citizen.setGender(request.getGender());
		}
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())) {
		
			LocalDate date = LocalDate.parse(request.getStartDate());
			citizen.setPlanStartDate(date);
		}
		if(null!=request.getEndDate() && !"".equals(request.getEndDate())) {
			
			LocalDate date = LocalDate.parse(request.getEndDate());
			citizen.setPlanEndDate(date);
		}
		return repo.findAll(Example.of(citizen));
		
	}
	
	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
			File f =new File("plans.xls");
		
		List<CitizensPlan> plans = repo.findAll();
		
		excelGenerator.generateExcel(response, plans);
		emailUtils.sentEmails("Test Email", "<h2>Test Email </h2>", "madhavpreeth123@gmail.com",f);
		f.delete();
		return true; 
	
		
	}
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f=new File("plans.pdf");
		List<CitizensPlan> plans = repo.findAll();
		pdfGnerator.pdfGenerator(response, plans,f);
		emailUtils.sentEmails("Test Email", "<h2>Test Email </h2>", "madhavpreeth394@gmail.com",f);
		f.delete();
		return true;
	}
}
