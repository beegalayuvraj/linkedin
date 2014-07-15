package com.aris.logintest;

import com.aris.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aris.authorization.Execute;
import com.aris.vo.logindetails.LoginDetails;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
@ContextConfiguration("classpath:/test-app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class LoginTest {
	@Autowired
	private Execute execute;
	
	@Autowired
	private SERVICE service;
	 //SERVICE service=new SERVICE();
	
	@Test
	public void test()
	{
		
		String consumerKey = "wnzk0nhsjqtt"; // The application's consumer key
		String consumerSecret = "HrSa5HtM3pHHkGvQ"; // The application's
		// consumer secret
		String accessToken = "3be8339a-a9ce-4783-8458-267165d0d9ac"; // The
																		// access
																		// token
																		// granted
																		// after
																		// OAuth
																		// authorization
		String accessTokenSecret = "8ddb7586-824d-4629-91bb-55146554413d"; // The
																			// access
																			// token
		//LinkedInTemplateExt linkedInTemplate=new LinkedInTemplateExt(consumerKey,consumerSecret,accessToken,accessTokenSecret);														// secret
																		// granted
		LoginDetails loginDetails=new LoginDetails();
		loginDetails.setConsumerKey(consumerKey);
		loginDetails.setConsumerSecret(consumerSecret);
		loginDetails.setAccessToken(accessToken);
		loginDetails.setAccessTokenSecret(accessTokenSecret);
		service.save(loginDetails);
		 XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
	        xstream.alias("loginDetails", LoginDetails.class);
	       // System.out.println(xstream.toXML(loginDetails));	
	 	 LinkedIn  linkedin= execute.test(loginDetails);
	 	System.out.println(linkedin.networkUpdateOperations().getCurrentShare().getComment().toString());
	 	
	 /*	if (linkedInTemplate != null) {
			linkedInTemplate.updateStatus("Testing");
		}*/
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	/* 	 
	 	 
	 	 
	 	 
	 	 Share sharecontent=linkedin.networkUpdateOperations().getCurrentShare();
	 	
	 	   
	 	   
	 	   
	 	   System.out.println(sharecontent.getComment());
	 	  System.out.println(sharecontent.getContent());
	 	 System.out.println(sharecontent.getVisibility());
		  
	 	*/ 
	 	 
	 	 /*
           System.out
		.println("-----------------------------------------------------");
	int id = 1;
	System.out.println("------------------CONNECTIONS ---------------");
	System.out.println("\tFirst Name\t Last Name \t \t Industry ");
	System.out
			.println("-----------------------------------------------------");
	for (LinkedInProfile linkedinprofile : linkedin
			.connectionOperations().getConnections()) {
		System.out.println(id + "\t" + linkedinprofile.getFirstName()
				+ "\t" + linkedinprofile.getLastName() + "\t"
				+ linkedinprofile.getIndustry());
		id++;
	  } */
	 	   
	}

}
