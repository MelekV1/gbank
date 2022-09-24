package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TSB.DEV.spring.model.Beneficiaire;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long>{
//	@Query("SELECT u FROM Beneficiaire u WHERE u.id = :Pid ")
//	Beneficiaire getSelectedBeneficiaire(@Param("Pid") Long id);
	Beneficiaire findByRibBeneficiaire(String rib);
}
