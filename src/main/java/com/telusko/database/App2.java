package com.telusko.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.telusko.userData;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
		
		 // userData ud = new userData("dev", "123");
		  userData ud = new userData();
		  
		  Session session = factory.openSession();
		  
		  @SuppressWarnings("deprecation")
		  Criteria criteria = session.createCriteria(userData.class);
		  criteria.add(Restrictions.eq("name", "dev"));
		  criteria.add(Restrictions.eq("password", "13"));
		  
		  ud = (userData)criteria.uniqueResult();
		  
		  if(ud!=null) 
			  {
			     
			  }
		  else System.out.println(false);
		  
		
		  Transaction tx = session.beginTransaction();
		  
		  session.save(ud);
		  
		  tx.commit();
		
		
		System.out.println(factory);
		System.out.println(factory);

	}

}
