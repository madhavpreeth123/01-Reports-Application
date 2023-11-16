package in.madhav.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.madhav.entity.CitizensPlan;
@Component
public class ExcelGenerator {

	public void generateExcel(HttpServletResponse response,List<CitizensPlan> plans) throws Exception {
		
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Plans_Informaton");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("CitizenName");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("PlanName");
		headerRow.createCell(4).setCellValue("PlanStatus");
		headerRow.createCell(5).setCellValue("PlanStartDate");
		headerRow.createCell(6).setCellValue("PlanEndDate");
		headerRow.createCell(7).setCellValue("BenficialAmount");
		
		int rowCount=1;
		for(CitizensPlan plan: plans) {
			Row row = sheet.createRow(rowCount);
			row.createCell(0).setCellValue(plan.getCitizenId());
			row.createCell(1).setCellValue(plan.getCitizenName());
			row.createCell(2).setCellValue(plan.getGender());
			row.createCell(3).setCellValue(plan.getPlanName());
			row.createCell(4).setCellValue(plan.getPlanStatus());
			if(null!=plan.getPlanStartDate()) {
			row.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			}
			else {
				row.createCell(5).setCellValue("N/A");
			}
			if(null!=plan.getPlanEndDate()) {
			row.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			}
			else {
				row.createCell(6).setCellValue("N/A");
			}
			if(null!=plan.getBenifiAmount()) {
			row.createCell(7).setCellValue(plan.getBenifiAmount()+"");
			}
			else {
				row.createCell(7).setCellValue("N/A");
			}
			rowCount++;
		}
		// file output stream create file in current folder
		FileOutputStream fout=new FileOutputStream(new File("plans.xls"));
		workbook.write(fout);
		fout.close();
		
		//send to the browser
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
}
