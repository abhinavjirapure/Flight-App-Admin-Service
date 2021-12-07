package com.flight.admin.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.admin.entity.UserLoginEntity;
import com.flight.admin.model.UserLoginDetails;
import com.flight.admin.repository.UserLoginRepository;


@Service
public class UserLoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginService.class);

	@Autowired
	UserLoginRepository userRepo;

	@Autowired
	UserLoginEntity userLoginEntity;

	public String userLogin(UserLoginDetails requestModel) {
		logger.info("Inside userLogin service method");
		try {
			userLoginEntity.setUserName(requestModel.getUserName());
			userLoginEntity.setPassword(requestModel.getPassword());
			logger.info("Creating db query");
			userRepo.save(userLoginEntity);
		}catch(Exception e)
		{
			logger.info("Exception occur"+e);	
		}
		return null;
	}

	public String userAuthentication(long userID) {

		String un = "abhinav@123";
		String p = "spiderman";
		logger.info("Inside userAuthentication service method");
		logger.info("Creating db query");
		Optional<UserLoginEntity> list = userRepo.findById(userID);
		if(list.isPresent())
		{
			UserLoginEntity e = list.get();
			if(e.getUserName().equals(un) && e.getPassword().equals(p))
			{
				return "User Authentication Successful...";
			}
			else
			{
				return  "User Authentication Fail...";
			}
		}
		else
		{
			return "Data Not Found...";
		}

	}


}
