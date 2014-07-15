package com.aris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.aris.vo.logindetails.*;
public class DAO {
	LoginDetails logindetails1;
	private EntityManagerFactory entitymanagerFactory=Persistence.createEntityManagerFactory("com.aris.spring-social");
	EntityManager entitymanager=entitymanagerFactory.createEntityManager();
	public void saveLoginDetails(LoginDetails logindetails)
	{	
		entitymanager.getTransaction().begin();
		entitymanager.persist(logindetails);
		System.out.println(logindetails);
		entitymanager.getTransaction().commit();
	    entitymanager.close();
	}
	
	public void deleteLoginDetails(LoginDetails logindetails)
	{
		entitymanager.getTransaction().begin();
		entitymanager.remove(logindetails);
	    entitymanager.close();
	}
	public LoginDetails getLoginDetails(String ConsumerKey,String ConsumerSecret)
	{
		entitymanager.getTransaction().begin(); 
		List<LoginDetails> result = entitymanager.createQuery( "from linkedin",LoginDetails.class).getResultList();
		for ( LoginDetails logindetails : result )
		{
			if(logindetails.getConsumerKey()==ConsumerKey && logindetails.getConsumerSecret()==ConsumerSecret)
			{
				 logindetails1=logindetails; 
				System.out.println( "Login Details :\n" + logindetails.getConsumerKey() +"\t"+logindetails.getConsumerSecret()+"\t"+logindetails.getAccessToken()+"\t"+logindetails.getAccessTokenSecret());

			}
			
		}	 
		return logindetails1;
					
	}
}
