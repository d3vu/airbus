package com.telusko.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.userData;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
		
		  userData ud = new userData();
		  System.out.println(ud);
		  Session session = factory.openSession();
		  
		  Transaction tx = session.beginTransaction();
		  
		  session.save(ud);
		  
		  tx.commit();
		
		
		System.out.println(factory);
	}

}
