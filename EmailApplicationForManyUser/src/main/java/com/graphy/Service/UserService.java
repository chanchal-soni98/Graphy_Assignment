package com.graphy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphy.Exception.EmailException;
import com.graphy.Repository.UserRepository;
import com.graphy.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//creating new user into database.
	
	public User createUser(User u) throws EmailException {
		
		User user = userRepo.findByEmail(u.getEmail());
		
		if(user==null) {
			return userRepo.save(u);
		}else {
			throw new EmailException("User already exist");
		}
	}

}
