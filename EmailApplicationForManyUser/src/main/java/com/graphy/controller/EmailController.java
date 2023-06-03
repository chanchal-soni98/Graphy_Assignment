package com.graphy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphy.Exception.EmailException;

import com.graphy.Service.EmailService;
import com.graphy.Service.UserService;
import com.graphy.model.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/emailSystem")
public class EmailController {
	@Autowired
	private EmailService es;
	
	@Autowired
	private UserService  us;

    //Add user in database
    
    @PostMapping("/user")
    public ResponseEntity<User> createNewUserHandler(@Valid @RequestBody User u) throws EmailException{//@Valid to apply input validition.
    	
    	User newUser = us.createUser(u);
    	 
    	return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }
    
    //Email sending method.
    @GetMapping("/send/{page}")
    public ResponseEntity<String> sendEmailsHandler(@PathVariable int page) {
        try{es.sendEmailsToUser(page);
        String str = "Emails sent successfully for page: " + page;
        
        return ResponseEntity.ok(str);
        }catch(Exception ie) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't send mail, server errors can be there");
        }
    }
	//

}
