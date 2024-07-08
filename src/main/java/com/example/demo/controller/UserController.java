package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
  //  =========================================================================
    @PostMapping("/save")
    public String createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
  // =========================================================================

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    //=========================================================================
    @DeleteMapping("/remove/{id}")
   
   public String delete(@PathVariable int id)
   {
		return userService.delete(id);
    	
   }
    
  //=========================================================================
    @PutMapping("/update/{id}")

    public User update(@PathVariable int id,@RequestBody User user)
    {
    	return userService.update(id,user);
    }
}
    

