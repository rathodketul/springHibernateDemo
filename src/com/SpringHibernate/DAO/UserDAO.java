package com.SpringHibernate.DAO;

import com.SpringHibernate.model.UserMaster;

public interface UserDAO {
	public boolean userAuthendication(UserMaster userMaster);
	public UserMaster getUser(String email_address);
	public boolean updUser(UserMaster userMaster);
}
