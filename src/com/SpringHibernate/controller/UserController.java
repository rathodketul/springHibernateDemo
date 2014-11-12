
package com.SpringHibernate.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.SpringHibernate.facade.CityFacade;
import com.SpringHibernate.facade.StateFacade;
import com.SpringHibernate.facade.UserFacade;
import com.SpringHibernate.model.UserMaster;
import com.SpringHibernate.util.Constants;

@Controller
@SessionAttributes({"sessionuser"})
public class UserController {
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	UserFacade userFacade;
	
	@Autowired
	CityFacade cityFacade;
	
	@Autowired
	StateFacade stateFacade;
	
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public ModelAndView AdminAuthendication(@ModelAttribute("command") UserMaster userMaster){
		try{
			if(userFacade.userAuthendication(userMaster)){
				return new ModelAndView("Home").addObject("sessionuser", userMaster.getEmail_address());
			}
			else{
				return new ModelAndView("Login").addObject("errormessage", Constants.LOGIN_FAILURE);
			}
		}
		catch(Exception e){
			logger.error(e);
			return new ModelAndView("Login").addObject("errormessage", Constants.LOGIN_FAILURE);
		}
	}
	
	@RequestMapping(value="/Profile",method=RequestMethod.GET)
	public ModelAndView showProfilePage(HttpSession session){
		try{
			UserMaster userMaster=userFacade.getUser(session.getAttribute("sessionuser").toString());
			return new ModelAndView("Profile")
			.addObject("user", userMaster)
			.addObject("state", stateFacade.getAllState())
			.addObject("city", cityFacade.getCitiesByState_id(userMaster.getState_master().getState_id()));
		}
		catch(Exception e){
			logger.error(e);
			return new ModelAndView("Profile");
		}
	}
}


