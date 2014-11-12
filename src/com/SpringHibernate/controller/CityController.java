package com.SpringHibernate.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringHibernate.facade.CityFacade;

@Controller
public class CityController {
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	CityFacade cityFacade;
	
	@RequestMapping(value="/getCity",method=RequestMethod.GET)
	public ModelAndView getCityBystate_id(@RequestParam("state_id") int state_id){
		Map<Integer, String> cities=cityFacade.getCitiesByState_id(state_id);
        return new ModelAndView("Profile").addObject("city", cities);
	}
}
