package in.madhav.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.madhav.entity.CitizensPlan;

@Component
public class PdfGenerator {

	
	public void pdfGenerator(HttpServletResponse response,List<CitizensPlan> plans,File f) throws Exception {
		

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph p = new Paragraph("Plans Info", fontTiltle);

		// Aligning the paragraph in document
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		
		document.add(p);
		PdfPTable table=new PdfPTable(8);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("Benficial Amount");
		
		
		for(CitizensPlan plan: plans) {
			table.addCell(plan.getCitizenId()+"");
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(plan.getBenifiAmount()+"");
			
		}
		
		
		document.add(table);
		document.close();
		
		
	}
}
