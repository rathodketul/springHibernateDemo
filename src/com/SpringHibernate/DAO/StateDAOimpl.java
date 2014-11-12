
package com.SpringHibernate.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringHibernate.model.StateMaster;

/**
@aurthor indianic
 */
@Repository
public class StateDAOimpl implements StateDAO{
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StateMaster> getAllState() {
		List<StateMaster> stateLst = null;
		try{
			Session session  = sessionFactory.getCurrentSession();
			stateLst= session.createCriteria(StateMaster.class).list();
			return stateLst;
		}
		catch(Exception e){
			logger.error("State Data Fetching "+e.getMessage());
			return stateLst;
		}
		finally{
			stateLst=null;
		}
	}
	
}
