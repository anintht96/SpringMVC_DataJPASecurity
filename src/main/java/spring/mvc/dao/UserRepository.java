package spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.mvc.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	@Query("Select u from User u where u.username = :username")
	public User getUserByUsername(@Param(value = "username")String username);
	
	public User findByUsername(String username);
	
}
