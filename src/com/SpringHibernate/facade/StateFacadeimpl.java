
package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	StateDAO stateDAO;

	@Transactional
	@Override
	public Map<Integer, String> getAllState(){
		Map<Integer, String> map=new HashMap<Integer, String>();
		List<StateMaster> states=stateDAO.getAllState();
		for(StateMaster sm:states){
			map.put(sm.getState_id(), sm.getState_name());
		}
		return map;
	}
	
	
	
}
