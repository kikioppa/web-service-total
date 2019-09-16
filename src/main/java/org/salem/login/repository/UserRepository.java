package org.salem.login.repository;


import org.salem.login.model.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailIgnoreCase(String email);
    User findByIsEnabled(Boolean isEnabled);
    User findByEmail(String email);

	
}