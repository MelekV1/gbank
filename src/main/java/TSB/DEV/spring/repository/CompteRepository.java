package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TSB.DEV.spring.model.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    //Compte findByName(String name);
    Compte findByRibCompte(String ribCompte);
}
