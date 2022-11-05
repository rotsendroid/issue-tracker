package top.agrisopt.issuetracker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.agrisopt.issuetracker.entities.User;
import top.agrisopt.issuetracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(u -> users.add(u));
		
		return users;
	}

}
