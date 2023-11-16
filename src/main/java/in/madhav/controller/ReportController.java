package in.madhav.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.madhav.entity.CitizensPlan;
import in.madhav.request.SearchRequest;
import in.madhav.service.ReportService;


@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=\"plans.pdf\"");
		service.exportPdf(response);
	}
	
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=\"plans.xls\"");
		service.exportExcel(response);
	}
	
	
	
	@PostMapping("/search")
	public String searchOperation(@ModelAttribute("search") SearchRequest search,Model model) {
		List<CitizensPlan> plan = service.search(search);
		model.addAttribute("plan", plan);
		
		init(model);
		return "index";
	}
	
	
	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}


	private void init(Model model) {
		
		model.addAttribute("plans",service.getplanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
	
}
