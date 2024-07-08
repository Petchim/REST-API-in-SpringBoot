package com.example.demo.service;

import com.example.demo.exception.DuplicateEmailException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// posting
	// =========================================================================
	public String saveUser(User user) {
		// email exepction
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser.isPresent()) {
			throw new DuplicateEmailException("User with name " + user.getEmail() + " already exists");
		}
		 userRepository.save(user);
		 return "data post in database!";
	}

	// getting
//=========================================================================
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	       //delete****    
	// =========================================================================

	public String delete(int id) {
		
	//  code for if id is not there not delete in saran database *******************
		User user1 = userRepository.findById(id)
                .orElseThrow(() -> new DuplicateEmailException("User not found with id " + id));
        
	user1.setId(id);
		userRepository.deleteById((int) id);
		
		return " delete the data ";
	}
	
              //update	
	// =========================================================================

	public User update(int id, User user) {
		//  code for if id is not there not update in saran database *******************
		  User user1 = userRepository.findById(id)
	                .orElseThrow(() -> new DuplicateEmailException("User not found with id " + id));
	        
		user1.setId(id);
		return userRepository.save(user1); 
	}

}
