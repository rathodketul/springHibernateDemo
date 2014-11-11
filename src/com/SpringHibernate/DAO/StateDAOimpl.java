
package com.SpringHibernate.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringHibernate.model.StateMaster;
import com.SpringHibernate.util.Constants;

/**
@aurthor indianic
 */
@Repository
public class StateDAOimpl implements StateDAO{
	
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getAllState() {
		List<StateMaster> stateLst = null;
		HashMap<String,Object> stateResponse = new HashMap<String,Object>();
		try{
			Session session  = sessionFactory.getCurrentSession();
			Criteria crit= session.createCriteria(StateMaster.class);
			stateLst = crit.list();
			logger.info("Fetching State Data Size:: "+stateLst.size());
			if (stateLst.size() != 0) {
				logger.info("Fetch State Data Success");
				stateResponse.put("STATELIST", stateLst);
			}
			else{
				logger.error("No State data found...");
			}
			return stateResponse;
		}
		catch(Exception e){
			stateResponse.put("CODE", Constants.ERROR_CODE);
			logger.error("State Data Fetching "+e.getMessage());
			return stateResponse;
		}
		finally{
			stateResponse=null;
			stateLst=null;
		}
	}
	
}
