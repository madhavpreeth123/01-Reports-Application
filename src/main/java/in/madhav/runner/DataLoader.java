package in.madhav.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.madhav.entity.CitizensPlan;
import in.madhav.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		//cashplan data -approved
		CitizensPlan c1=new CitizensPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifiAmount(5000.00);
		
		CitizensPlan c2=new CitizensPlan();
		
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");
		
		CitizensPlan c3=new CitizensPlan();
		c3.setCitizenName("Berl");
		c3.setGender("FeMale");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifiAmount(5000.00);
		c3.setTerminationDate(LocalDate.now());
		c3.setTerminationReason("Employee");
		
		//Food Plan
		CitizensPlan c5=new CitizensPlan();
		c5.setCitizenName("Siema");
		c5.setGender("FeMale");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");
		
		CitizensPlan c4=new CitizensPlan();
		
		c4.setCitizenName("Ram");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifiAmount(4000.00);
		
		
		CitizensPlan c6=new CitizensPlan();
		c6.setCitizenName("Cathey");
		c6.setGender("FeMale");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifiAmount(5000.00);
		c6.setTerminationDate(LocalDate.now());
		c6.setTerminationReason("Employee");
		//Medical Plan
		CitizensPlan c7=new CitizensPlan();
		c7.setCitizenName("Chrles");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Denied");
		c7.setDenialReason("Property Income");
		
		CitizensPlan c8=new CitizensPlan();
		
		c8.setCitizenName("Robert");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Approved");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setBenifiAmount(7000.00);
		
		
		CitizensPlan c9=new CitizensPlan();
		c9.setCitizenName("Smitha");
		c9.setGender("FeMale");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(3));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifiAmount(5000.00);
		c9.setTerminationDate(LocalDate.now());
		c9.setTerminationReason("Government Job");
		//Employement plan
		CitizensPlan c10=new CitizensPlan();
		c10.setCitizenName("Madhav");
		c10.setGender("Male");
		c10.setPlanName("Employement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifiAmount(5000.00);
		
		CitizensPlan c11=new CitizensPlan();
		
		c11.setCitizenName("Hemanth");
		c11.setGender("Male");
		c11.setPlanName("Employement");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Rental Income");
		
		CitizensPlan c12=new CitizensPlan();
		c12.setCitizenName("Keerthana");
		c12.setGender("FeMale");
		c12.setPlanName("Employement");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifiAmount(5000.00);
		c12.setTerminationDate(LocalDate.now());
		c12.setTerminationReason("Employee");
		
		List<CitizensPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
	}
}
