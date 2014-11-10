
package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.CityDAO;
import com.SpringHibernate.model.CityMaster;

/**
@aurthor indianic
 */
@Service
public class CityFacadeimpl implements CityFacade{
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	CityDAO cityDAO;
	
	@Transactional
	@Override
	public HashMap<Integer, String> getCitiesByState_id(int state_id) {
		List<CityMaster> cityLst = null;
		HashMap<Integer, String> cities=new HashMap<Integer, String>();
		HashMap<String, Object> cityResponse=cityDAO.getCitiesByState_id(state_id);
		try{
			cityLst=(List<CityMaster>) cityResponse.get("CITYLIST");
			for(CityMaster cm:cityLst){
				cities.put(cm.getCity_id(), cm.getCity_name());
			}
			return cities;
		}
		catch(Exception e){
			logger.error(e.getMessage());
			return cities;
		}
		finally{
			cityLst=null;
			cities=null;
			cityResponse=null;
		}
	}

}
