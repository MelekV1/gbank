package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TSB.DEV.spring.model.Virement;

public interface VirementRepository extends JpaRepository<Virement,Long> {
}
