package spring.mvc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.UserRepository;
import spring.mvc.dao.UserRoleRepository;
import spring.mvc.entities.User;
import spring.mvc.entities.UserRole;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo() {
		return "userInfo";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(@ModelAttribute(name = "user") User user) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postRegister(@ModelAttribute(name = "user") User user) {
		if(userRepository.findById(user.getUsername()).isPresent()) {
			return new ModelAndView("403", "message", "Username already exists.");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnable(true);
		userRepository.save(user);
		return new ModelAndView("info", "infoRegister", "Successful Register .");
	}

	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public ModelAndView getAllUser(@ModelAttribute(name = "user") User user) {
		return new ModelAndView("admin-user", "list", userRepository.findAll());
	}

	@RequestMapping(value = "/admin/user-view/{username}", method = RequestMethod.GET)
	public ModelAndView getUser(@ModelAttribute(name = "user") User user,
			@PathVariable(name = "username") String username, Model model) {
		model.addAttribute("list", userRepository.findAll());
		model.addAttribute("username", username);
		return new ModelAndView("admin-user", "userRoles", userRoleRepository.findByUser(new User(username)));
	}

	@RequestMapping(value = "/admin/user-addRole/{username}", method = RequestMethod.GET)
	public ModelAndView getAddUserRole(@ModelAttribute(name = "userRole") UserRole userRole,
			@PathVariable(name = "username") String username) {
		return new ModelAndView("admin-addRole", "user", username);
	}

	@RequestMapping(value = "/admin/user-addRole", method = RequestMethod.POST)
	public String postAddUserRole(@ModelAttribute(name = "userRole") UserRole userRole) {
		userRoleRepository.save(userRole);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("message", "You do not have permission to access this page!");
		}
		return "403";
	}
	
	@RequestMapping(value = "/admin/userRole-delete/{roleId}",method = RequestMethod.GET)
	public String userRoleDelete(@PathVariable(name = "roleId")Integer id) {
		userRoleRepository.deleteById(id);
		return "redirect:/admin/user";
	}
}
