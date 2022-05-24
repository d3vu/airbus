package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterContorller {
	
	private String name;
	private String password;
	@RequestMapping(value="register")
	public ModelAndView storeData(@RequestParam("name") String name,@RequestParam("password") String password)
	{
		System.out.println("Hello");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
		
		  userData ud = new userData(name,password);
		  System.out.println(ud);
		  Session session = factory.openSession();
		  
		  Transaction tx = session.beginTransaction();
		  
		  session.save(ud);
		  tx.commit();
		
		/*
		 * userData ud = new userData(name,password);
		 * 
		 * Session session = factory.openSession();
		 * 
		 * Transaction tx = session.beginTransaction();
		 * 
		 * session.save(ud);
		 * 
		 * tx.commit(); System.out.println("data saved"); session.close();
		 */
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("login.jsp");
		
		return mv;
		
	}

}
