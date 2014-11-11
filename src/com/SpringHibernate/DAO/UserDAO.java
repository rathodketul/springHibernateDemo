package com.SpringHibernate.DAO;

import java.util.HashMap;

import com.SpringHibernate.model.UserMaster;

public interface UserDAO {
	public HashMap<String, Object> userAuthendication(UserMaster userMaster);
	public HashMap<String, Object> getAllAdmin();
}
