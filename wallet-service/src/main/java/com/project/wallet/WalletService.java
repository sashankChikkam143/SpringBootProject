package com.project.wallet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
	
	@Autowired
	WalletRepo walletRepo;
	
	private static final String USER_CREATE_TOPIC ="usercreate";
	int intialBalance=100;
	
	@KafkaListener(topics = {USER_CREATE_TOPIC}, groupId="Ewallet")
	public void walletCreate(String message) throws Exception
	{
		JSONObject jo = (JSONObject) new JSONParser().parse(message); 
		
		if(!jo.containsKey("userId"))
		{
			throw new Exception("userId is not present");
		}
		int userId=((Long)jo.get("userId")).intValue();
		Wallet wallet=Wallet.builder().balance(intialBalance).userId(userId).build();
		walletRepo.save(wallet);
	}

}
