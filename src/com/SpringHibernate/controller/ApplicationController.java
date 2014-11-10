
package com.SpringHibernate.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.SpringHibernate.facade.StateFacade;
import com.SpringHibernate.model.UserMaster;

/**
	@aurthor indianic
 */

@Controller
public class ApplicationController {
	
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	StateFacade stateFacade;
	
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String showLoginpage(@ModelAttribute("command") UserMaster adminMaster){
		logger.info("Loading User Login.....");
		return "/Login";
	}
	
	@RequestMapping(value="/admin/adminLogin",method=RequestMethod.GET)
	public String showAdminLoginpage(@ModelAttribute("command") UserMaster adminMaster){
		logger.info("Loading Admin Login.....");
		return "/admin/adminLogin";
	}
	
	@RequestMapping(value="/admin/adminAddpackage",method=RequestMethod.GET)
	public ModelAndView showaddPackagePage(){
		logger.info("Loading Add Package.....");
		HashMap<Integer, String> states=stateFacade.getAllState();
		HashMap<Integer, String> cities=new HashMap<Integer, String>();
		cities.put(1, "Select City");
		return new ModelAndView("/admin/adminAddpackage")
					.addObject("states", states)
					.addObject("cities",cities);
	}
	
	@RequestMapping(value="admin/doAdminLogOut")
	public String adminLogout(@ModelAttribute("command") UserMaster adminMaster,HttpSession session) {
		logger.info("Admin Logout Success");
		session.removeAttribute("sessionuser");
		return "adminLogin";
	}
	
	@RequestMapping(value="admin/adminForgotpass")
	public String adminForgotPassword(@ModelAttribute("command") UserMaster adminMaster) {
		logger.info("Admin Forgot Password....");
		return "adminForgotpass";
	}
}
