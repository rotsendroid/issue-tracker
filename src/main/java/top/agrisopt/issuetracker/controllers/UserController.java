package top.agrisopt.issuetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import top.agrisopt.issuetracker.repository.UserRepository;
import top.agrisopt.issuetracker.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/register")
	public String viewRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/post-register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "registration_complete";
	}
}
