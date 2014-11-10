package com.SpringHibernate.DAO;

import java.util.HashMap;

import com.SpringHibernate.model.AdminMaster;

public interface AdminDAO {
	public HashMap<String, Object> adminAuthendication(AdminMaster adminMaster);
	public HashMap<String, Object> getAllAdmin();
}
