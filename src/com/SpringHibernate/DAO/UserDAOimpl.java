package com.SpringHibernate.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringHibernate.model.UserMaster;

@Repository
public class UserDAOimpl implements UserDAO{
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean userAuthendication(UserMaster userMaster){
		boolean flag=false;
		try{
			Session session  = sessionFactory.getCurrentSession();
			List<Integer> usrLst= session.createCriteria(UserMaster.class)
					.setProjection(Projections.count("user_id"))
					.add(Restrictions.eq("email_address",userMaster.getEmail_address()))
					.add(Restrictions.eq("password",userMaster.getPassword()))
					.list();
			int i=usrLst.get(0);
			if(i>0){
				flag=true;
			}
			return flag;
		}
		catch(Exception e){
			logger.error("Login Error "+e.getMessage());
			return flag;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserMaster getUser(String email_address) {
		UserMaster userMaster=new UserMaster();
		try{
			Session session  = sessionFactory.getCurrentSession();
			List<UserMaster> usrLst= session.createCriteria(UserMaster.class)
					.add(Restrictions.eq("email_address",email_address))
					.list();
			userMaster=usrLst.get(0);
		}
		catch(Exception e){
			logger.error("Profile Error "+e.getMessage());
		}
		return userMaster;
	}

	@Override
	public boolean updUser(UserMaster userMaster) {
		boolean flag=false;
		try{
			Session session  = sessionFactory.getCurrentSession();
			String hql = "UPDATE UserMaster set first_name = :first_name,last_name=:last_name,address=:address,state_id=:state_id,city_id=:city_id WHERE email_address = :email_address";
			Query query = session.createQuery(hql);
			query.setParameter("first_name", userMaster.getFirst_name());
			query.setParameter("last_name", userMaster.getLast_name());
			query.setParameter("address", userMaster.getAddress());
			query.setParameter("state_id", userMaster.getState_master().getState_id());
			query.setParameter("city_id", userMaster.getCity_master().getCity_id());
			query.setParameter("email_address", userMaster.getEmail_address());
			int result = query.executeUpdate();
			if(result > 0)
				flag=true;
		}
		catch(Exception e){
			logger.error("Profile Updation Error "+e.getMessage());
		}
		return flag;
	}
	

}
