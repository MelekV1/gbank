package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TSB.DEV.spring.model.VirementPermanent;

@Repository
public interface VirementPermanentRepository extends JpaRepository<VirementPermanent, Long>{
	
//	@Query("SELECT u FROM Virement u WHERE u.id = :Pid ")
//	VirementPermanent  getSelectedVirementPermanent(@Param("Pid") Long id);
}
