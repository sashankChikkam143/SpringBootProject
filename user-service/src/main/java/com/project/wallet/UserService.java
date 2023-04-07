package com.project.wallet;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final String USER_CREATE_TOPIC="usercreate";

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	KafkaTemplate<String, String> kft;
	
	public User getUser(int id) {
		
		return userRepo.findById(id).get();
	}

	public User create(UserCreate usercreate) {
		
		//adding code to send  details to wallet service
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("userId", usercreate.to().getId());
		jsonObject.put("userEmail", usercreate.to().getEmail());
		jsonObject.put("contact", usercreate.to().getContact());
		// TODO Auto-generated method stub
		kft.send(USER_CREATE_TOPIC, jsonObject.toJSONString());
		return userRepo.save(usercreate.to());
	}
	
	

}
