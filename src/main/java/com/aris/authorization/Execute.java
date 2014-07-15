package com.aris.authorization;

import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.impl.LinkedInTemplate;

import com.aris.vo.logindetails.LoginDetails;



/*  import org.springframework.social.linkedin.api.LinkedIn;
 import org.springframework.social.linkedin.api.LinkedInProfile;
 import org.springframework.social.linkedin.api.ProfileOperations;
 import org.springframework.social.linkedin.api.impl.json.*;
 import org.springframework.social.linkedin.api.impl.LinkedInTemplate;
 import org.springframework.social.linkedin.api.impl.*;
 import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
 import org.springframework.social.linkedin.connect.LinkedInServiceProvider; 
public class Execute {*/
public class Execute{
	
	public LinkedIn test(LoginDetails login) {

		
		  LinkedIn linkedin = new
		LinkedInTemplate(login.getConsumerKey().toString(),
		login.getConsumerSecret().toString(),
		  login.getAccessToken().toString(),
		  login.getAccessTokenSecret().toString());
		
		/*
		 * ConnectionRepository connectionRepository=null;
		 * 
		 * Connection<LinkedIn> connection = connectionRepository
		 * .findPrimaryConnection(LinkedIn.class);
		 * 
		 * if (connection != null) { LinkedIn linkedin = connection.getApi(); }
		 */

		return linkedin;
	}
}
