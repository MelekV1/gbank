package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TSB.DEV.spring.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}