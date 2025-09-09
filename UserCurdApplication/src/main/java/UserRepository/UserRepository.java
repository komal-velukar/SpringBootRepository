package UserRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // No need to implement anything, Spring handles it
	Optional<User> findByEmailAndPassword(String email, String password);
	}

 
