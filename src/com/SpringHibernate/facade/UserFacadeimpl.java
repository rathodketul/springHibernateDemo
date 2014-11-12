package com.SpringHibernate.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.UserDAO;
import com.SpringHibernate.model.UserMaster;

@Service
public class UserFacadeimpl implements UserFacade {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public boolean userAuthendication(UserMaster userMaster) {
		return userDAO.userAuthendication(userMaster);
	}

	@Override
	@Transactional
	public UserMaster getUser(String email_address) {
		return userDAO.getUser(email_address);
	}

	
	
}
