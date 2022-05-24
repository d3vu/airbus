package com.telusko;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView authenticate(@RequestParam("name") String name, @RequestParam("password") String password)

	// public static void main(String[]args)
	{

		System.out.println(name + " " + password);

		System.out.println("hiii inside login");
		ModelAndView mv = new ModelAndView();

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		System.out.println(factory); // userData ud = new userData("dev", "123");
		userData ud = new userData();

		Session session = factory.openSession();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(userData.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));

		ud = (userData) criteria.uniqueResult();

		if (ud != null) {
			mv.setViewName("hi.jsp");
			mv.addObject("value", true);
			return mv;
		}

		
		

		session.close();

		mv.setViewName("login.jsp");
		mv.addObject("value", true);
		return mv;

		

	}

}
