package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TSB.DEV.spring.model.VirementMasse;

@Repository
public interface VirementMasseRepository extends JpaRepository<VirementMasse, Long>{
	
//	@Query("SELECT u FROM VirementMasse u WHERE u.id = :Pid ")
//	VirementMasse  getSelectedVirementMasse(@Param("Pid") Long id);
}
