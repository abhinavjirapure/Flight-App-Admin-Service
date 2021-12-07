package com.flight.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.admin.model.UserLoginDetails;
import com.flight.admin.service.UserLoginService;


@RestController
@RequestMapping(value="/api/v1.0")
public class UserLoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@Autowired
	UserLoginService userLoginService;

	@PostMapping(value = "/flight/app/user/login")
	public ResponseEntity<String> userLogin(@RequestBody UserLoginDetails requestModel) throws Exception
	{
		logger.info("Inside userLogin method");
		userLoginService.userLogin(requestModel);
		logger.info("Returning user login response");
		return new ResponseEntity<>("User Registered Successfully...",HttpStatus.OK);
	}

	@GetMapping(value ="/flight/user/auth/{userID}")
	public ResponseEntity<String> userAuthentication(@PathVariable long userID)
	{
		logger.info("Inside userAuthentication method");
		String result = userLoginService.userAuthentication(userID);
		logger.info("Returning user authentication response");
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
