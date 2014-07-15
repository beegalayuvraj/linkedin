package com.aris.ui.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.social.linkedin.api.Share;
import org.springframework.stereotype.Controller;


import com.aris.authorization.*;
import com.aris.login.details.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

@ManagedBean(name = "LoginMB")
@Controller
@ApplicationScoped
public class LoginMB {

	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;

	@ManagedProperty(value = "#{execute}")
	@Autowired
	private Execute execute;
	LinkedIn linkedin;

	public void display()
	{
		LoginDetails loginDetails=new LoginDetails();
		loginDetails.setConsumerKey(consumerKey);
		loginDetails.setConsumerSecret(consumerSecret);
		loginDetails.setAccessToken(accessToken);
		loginDetails.setAccessTokenSecret(accessTokenSecret);
		
		if((linkedin=getExecute().test(loginDetails))!=null)
		{
				LinkedInProfileFull linkedinfull = linkedin.profileOperations()
						.getUserProfileFull();
				String status=linkedin.networkUpdateOperations().getCurrentShare().getComment();
				System.out.println(status);
				   XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			        xstream.setMode(XStream.NO_REFERENCES);
			        xstream.alias("linkedinfull", LinkedInProfileFull.class);
			        
			        
			        FacesContext.getCurrentInstance().addMessage("LinkedInPrfoile\"<hr/>\"", new FacesMessage(xstream.toXML(linkedinfull)));
			        FacesContext.getCurrentInstance().addMessage("CURRENT STATUS:<br>",new FacesMessage(status));
				} 
	}
	public Execute getExecute() {
		return execute;
	}

	public void setExecute(Execute execute) {
		this.execute = execute;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

}
