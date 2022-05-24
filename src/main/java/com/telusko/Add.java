package com.telusko;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.service.AddService;
import com.telusko.service.SearchService;


@Controller
public class Add {
	
	
	@RequestMapping(value="add")
	public ModelAndView add(@RequestParam("color") String color, 
			@RequestParam("size") String size,@RequestParam("gender") String gender, 
			@RequestParam("outputPref") String outputPref)
	{	
		SearchService ss = new SearchService();
		ArrayList<String> ans = (ArrayList<String>) ss.getMatchingResult(color, gender, size, outputPref);
		
		//k = as.add(i, j);
		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("display.jsp");
		mv.addObject("ans", ans);
		return mv;
	}
	
	
	
	

}
