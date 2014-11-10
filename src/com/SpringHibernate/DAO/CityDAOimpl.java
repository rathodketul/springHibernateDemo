
package com.SpringHibernate.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringHibernate.model.CityMaster;
import com.SpringHibernate.model.StateMaster;
import com.SpringHibernate.util.Constant;

/**
@aurthor indianic
 */
@Repository
public class CityDAOimpl implements CityDAO{
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public HashMap<String, Object> getCitiesByState_id(int state_id) {
		List<StateMaster> cityLst = null;
		HashMap<String,Object> cityResponse = new HashMap<String,Object>();
		try{
			Session session  = sessionFactory.getCurrentSession();
			Criteria crit= session.createCriteria(CityMaster.class);
			crit.add(Restrictions.eq("state_id", state_id));
			cityLst = crit.list();
			logger.info("Fetching State Data Size:: "+cityLst.size());
			if (cityLst.size() != 0) {
				logger.info("Fetch State Data Success");
				cityResponse.put("CITYLIST", cityLst);
			}
			else{
				logger.error("No City data found...");
			}
			return cityResponse;
		}
		catch(Exception e){
			cityResponse.put("CODE", Constant.ERROR_CODE);
			logger.error("City Data Fetching "+e.getMessage());
			return cityResponse;
		}
		finally{
			cityResponse=null;
			cityLst=null;
		}
	}
	
}
