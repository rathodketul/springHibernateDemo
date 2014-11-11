package com.SpringHibernate.facade;

import java.util.HashMap;

import com.SpringHibernate.model.UserMaster;

public interface UserFacade {
	public HashMap<String, Object> userAuthendication(UserMaster userMaster);
	public HashMap<String, Object> getAdminPassword(UserMaster adminMaster);
}
