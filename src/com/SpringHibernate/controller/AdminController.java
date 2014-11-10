
package com.SpringHibernate.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.SpringHibernate.facade.AdminFacade;
import com.SpringHibernate.facade.CityFacade;
import com.SpringHibernate.model.AdminMaster;
import com.SpringHibernate.model.PackageMaster;
import com.SpringHibernate.util.Constant;

@Controller
@SessionAttributes({"sessionuser"})
public class AdminController {
	
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	AdminFacade adminFacade;
	
	@Autowired
	CityFacade cityFacade;
	
	@RequestMapping(value="admin/doAdminLogin")
	public ModelAndView AdminAuthendication(@ModelAttribute("command") AdminMaster adminMaster){
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			logger.info("Checking Authendication");
			userResponse=adminFacade.adminAuthendication(adminMaster);
			if(userResponse.get("CODE").equals(Constant.SUCCESS_CODE)){
				return new ModelAndView("Home").addObject("sessionuser", adminMaster.getUserName());
			}
			else{
				map.put("errormessage", Constant.LOGIN_FAILURE);
				return new ModelAndView("adminLogin", map);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("errormessage", Constant.LOGIN_FAILURE);
			return new ModelAndView("adminLogin", map);
		}
		finally{
			userResponse=null;
			map=null;
		}
	}
	
	@RequestMapping(value="admin/doAdminForpass")
	public String AdminForgotpassword(@ModelAttribute("command") AdminMaster adminMaster){
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		try{
			userResponse=adminFacade.getAdminPassword(adminMaster);
			if(userResponse.get("CODE").equals(Constant.SUCCESS_CODE)){
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
	
	@RequestMapping(value="/admin/getCity",method = RequestMethod.GET)
    public ModelAndView setupForm(@RequestParam("Id") int id,@ModelAttribute("command")PackageMaster packageMaster) {
		HashMap<Integer, String> cities=new HashMap<Integer, String>();
		cities=cityFacade.getCitiesByState_id(id);
        return new ModelAndView("adminAddpackage","packageMaster",packageMaster)
					.addObject("cities", cities);
    }
}


