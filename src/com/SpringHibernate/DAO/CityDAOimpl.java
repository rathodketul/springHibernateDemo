
package com.SpringHibernate.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringHibernate.model.CityMaster;

/**
@aurthor indianic
 */
@Repository
public class CityDAOimpl implements CityDAO{
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CityMaster> getCitiesByState_id(int state_id) {
		List<CityMaster> cityList = null;
		try{
			Session session  = sessionFactory.getCurrentSession();
			cityList=session.createCriteria(CityMaster.class)
					.add(Restrictions.eq("state_master.state_id", state_id))
					.list();
			return cityList;
		}
		catch(Exception e){
			logger.error("City Data Fetching "+e.getMessage());
			return cityList;
		}
	}
	
}
