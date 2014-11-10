package com.SpringHibernate.facade;

import java.util.HashMap;

import com.SpringHibernate.model.AdminMaster;

public interface AdminFacade {
	public HashMap<String, Object> adminAuthendication(AdminMaster adminMaster);
	public HashMap<String, Object> getAdminPassword(AdminMaster adminMaster);
}
