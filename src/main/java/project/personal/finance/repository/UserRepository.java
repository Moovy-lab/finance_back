package project.personal.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.personal.finance.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
