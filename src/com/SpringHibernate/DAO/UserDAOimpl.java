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

import com.SpringHibernate.model.UserMaster;
import com.SpringHibernate.util.Constants;

@Repository
public class UserDAOimpl implements UserDAO{
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> userAuthendication(UserMaster userMaster){
		List<UserMaster> usrLst = null;
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		try{
			Session session  = sessionFactory.getCurrentSession();
			Criteria crit= session.createCriteria(UserMaster.class)
					.add(Restrictions.eq("email_address",userMaster.getEmail_address()))
					.add(Restrictions.eq("password",userMaster.getPassword()));
			usrLst = crit.list();
			logger.info("Fetach Data Size:: "+usrLst.size());
			if (usrLst.size() != 0) {
				logger.info("Fetach Data Success");
				userResponse.put("CODE", Constants.SUCCESS_CODE);
				userResponse.put("MSG", Constants.LOGIN_SUCCESS);
			}
			else{
				logger.error("Login Fail");
				userResponse.put("CODE", Constants.ERROR_CODE);
				userResponse.put("MSG", Constants.LOGIN_FAILURE);
			}
			return userResponse;
		}
		catch(Exception e){
			userResponse.put("CODE", Constants.ERROR_CODE);
			userResponse.put("MSG", Constants.LOGIN_FAILURE);
			logger.error("Admin Login "+e.getMessage());
			return userResponse;
		}
		finally{
			userResponse=null;
			usrLst=null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getAllAdmin(){
		List<UserMaster> usrLst = null;
		HashMap<String, Object> userResponse = new HashMap<String, Object>();
		try{
			Session session  = sessionFactory.getCurrentSession();
			Criteria crit= session.createCriteria(UserMaster.class);
			usrLst = crit.list();
			logger.info("Fetch Admin Data Size:: "+usrLst.size());
			if (usrLst.size() != 0) {
				logger.info("Fetch Admin Data Success");
				userResponse.put("CODE", Constants.SUCCESS_CODE);
				userResponse.put("ADMINLIST", usrLst);
			}
			else{
				logger.error("No data found...");
				userResponse.put("CODE", Constants.ERROR_CODE);
			}
			return userResponse;
		}
		catch(Exception e){
			userResponse.put("CODE", Constants.ERROR_CODE);
			userResponse.put("MSG", Constants.LOGIN_FAILURE);
			logger.error("Admin Data Fetching "+e.getMessage());
			return userResponse;
		}
		finally{
			userResponse=null;
			usrLst=null;
		}
	}
}
