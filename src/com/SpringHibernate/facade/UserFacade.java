package com.SpringHibernate.facade;

import com.SpringHibernate.model.UserMaster;

public interface UserFacade {
	public boolean userAuthendication(UserMaster userMaster);
	public UserMaster getUser(String email_address);
	public boolean updUser(UserMaster userMaster);
}
