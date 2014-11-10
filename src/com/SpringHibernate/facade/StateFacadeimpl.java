
package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.StateDAO;
import com.SpringHibernate.model.StateMaster;

/**
@aurthor indianic
 */
@Service
public class StateFacadeimpl implements StateFacade{
	
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	StateDAO stateDAO;

	@Transactional
	@Override
	public HashMap<Integer, String> getAllState() {
		List<StateMaster> stateLst = null;
		HashMap<Integer, String> states=new HashMap<Integer, String>();
		HashMap<String, Object> stateResponse=stateDAO.getAllState();
		try{
			states.put(0, "Select State");
			stateLst=(List<StateMaster>) stateResponse.get("STATELIST");
			for(StateMaster sm:stateLst){
				states.put(sm.getState_id(), sm.getState_name());
			}
			return states;
		}
		catch(Exception e){
			logger.error(e.getMessage());
			return states;
		}
		finally{
			stateLst=null;
			states=null;
			stateResponse=null;
		}
	}
	
	
	
}
