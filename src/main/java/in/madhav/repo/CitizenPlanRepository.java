package in.madhav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.madhav.entity.CitizensPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizensPlan, Integer> {

	@Query("select distinct (planName) from CitizensPlan ")
	public List<String> getPlanNanes();
	
	@Query("select distinct (planStatus) from CitizensPlan ")
	public List<String> getPlanStatus();
}
