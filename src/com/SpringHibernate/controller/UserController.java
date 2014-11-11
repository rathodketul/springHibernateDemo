
package com.SpringHibernate.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.SpringHibernate.facade.CityFacade;
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
	
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public ModelAndView AdminAuthendication(@ModelAttribute("command") UserMaster userMaster){
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			logger.info("Checking Authendication");
			userResponse=userFacade.userAuthendication(userMaster);
			if(userResponse.get("CODE").equals(Constants.SUCCESS_CODE)){
				return new ModelAndView("Home").addObject("sessionuser", userMaster.getEmail_address());
			}
			else{
				map.put("errormessage", Constants.LOGIN_FAILURE);
				return new ModelAndView("adminLogin", map);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("errormessage", Constants.LOGIN_FAILURE);
			return new ModelAndView("adminLogin", map);
		}
		finally{
			userResponse=null;
			map=null;
		}
	}
	
	@RequestMapping(value="admin/doAdminForpass")
	public String AdminForgotpassword(@ModelAttribute("command") UserMaster adminMaster){
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		try{
			userResponse=userFacade.getAdminPassword(adminMaster);
			if(userResponse.get("CODE").equals(Constants.SUCCESS_CODE)){
				String pass=userResponse.get("PASSWORD").toString();
				logger.info("Password is ::"+pass);
			}
			else{
				logger.error("Password Not Found");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			userResponse=null;
		}
		return "adminForgotpass";
	}
}


