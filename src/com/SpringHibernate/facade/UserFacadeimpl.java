package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.UserDAO;
import com.SpringHibernate.model.UserMaster;
import com.SpringHibernate.util.Constant;

@Service
public class UserFacadeimpl implements UserFacade {
	
	@Autowired
	UserDAO adminDAO;
	
	@Override
	@Transactional
	public HashMap<String, Object> adminAuthendication(UserMaster adminMaster) {
		return adminDAO.adminAuthendication(adminMaster);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public HashMap<String, Object> getAdminPassword(UserMaster adminMaster) {
		HashMap<String, Object> adminResponse=new HashMap<String, Object>();
		List<UserMaster> adminMasterList;
		try{
			adminResponse=adminDAO.getAllAdmin();
			if(adminResponse.get("CODE").equals(Constant.SUCCESS_CODE)){
				adminMasterList=(List<UserMaster>) adminResponse.get("ADMINLIST");
				for(UserMaster am:adminMasterList){
					if(am.getUserName().equalsIgnoreCase(adminMaster.getUserName())){
						adminResponse.put("CODE", Constant.SUCCESS_CODE);
						adminResponse.put("PASSWORD", am.getPassword());
						break;
					}
					else{
						adminResponse.put("CODE", Constant.ERROR_CODE);
					}
				}
			}
			else{
				adminResponse.put("CODE", Constant.ERROR_CODE);
			}
			return adminResponse;
		}
		catch(Exception e){
			adminResponse.put("CODE", Constant.ERROR_CODE);
			return adminResponse;
		}
		finally{
			adminResponse=null;
			adminMasterList=null;
		}
	}
	
}
