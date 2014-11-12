
package com.SpringHibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringHibernate.model.UserMaster;

/**
	@aurthor indianic
 */

@Controller
public class ApplicationController {
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String showLoginpage(@ModelAttribute("command") UserMaster userMaster){
		return "/Login";
	}
	
	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public String showHomepage(){
		return "/Home";
	}
	
}
