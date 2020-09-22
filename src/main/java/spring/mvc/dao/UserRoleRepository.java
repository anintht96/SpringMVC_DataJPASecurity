package spring.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.mvc.entities.User;
import spring.mvc.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	@Query("Select r.userRole from UserRole r where r.user = :username")
	public List<String> getAllUsernameByUsername(@Param(value = "username") User user);
	
	public List<UserRole> findByUser(User user);
}
