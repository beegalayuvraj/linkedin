package com.aris.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.aris.dao.DAO;
import com.aris.vo.logindetails.LoginDetails;
public class SERVICE {

	@Autowired
	private DAO dao;
	//private DAO dao=new DAO();
	
	public void save(LoginDetails logindetails)
	{
		System.out.println(logindetails);
     dao.saveLoginDetails(logindetails);
	}
   public void delete(LoginDetails logindetails)
   {
	   dao.deleteLoginDetails(logindetails);
   }
   public LoginDetails get(String ConsumerKey,String ConsumerSecret)
   {
	   return dao.getLoginDetails(ConsumerKey,ConsumerSecret);
   }



}
