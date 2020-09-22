package spring.mvc.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.mvc.dao.UserRepository;
import spring.mvc.dao.UserRoleRepository;
import spring.mvc.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println("Not found username.");
			throw new UsernameNotFoundException(username + " Not found.");
		}
		List<String> roles=userRoleRepository.getAllUsernameByUsername(user);
		return new MyUserDetail(user,roles);
	}

}
