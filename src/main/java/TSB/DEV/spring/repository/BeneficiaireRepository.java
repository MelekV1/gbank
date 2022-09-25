package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TSB.DEV.spring.model.Beneficiaire;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long>{

	Beneficiaire findByRibBeneficiaire(String ribBeneficiaire);
}
