package com.aris.vo.logindetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="LinkedIn")
public class LoginDetails {
    @Id
	@Column(name="consumerKey")
	private String consumerKey;
	@Column(name="consumerSecret")
	private String consumerSecret;
	@Column(name="accessToken")
	private String accessToken;
	@Column(name="accessTokenSecret")
	private String accessTokenSecret;
/*	String consumerKey = "wnzk0nhsjqtt"; // The application's consumer key
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
																		// secret
																		// granted
																		// after
																		// OAuth
																		// authorization
*/
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
