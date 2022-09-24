package TSB.DEV.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TSB.DEV.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}