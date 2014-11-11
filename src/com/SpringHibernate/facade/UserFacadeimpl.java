package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.UserDAO;
import com.SpringHibernate.model.UserMaster;
import com.SpringHibernate.util.Constants;

@Service
public class UserFacadeimpl implements UserFacade {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public boolean userAuthendication(UserMaster userMaster) {
		return userDAO.userAuthendication(userMaster);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public HashMap<String, Object> getAdminPassword(UserMaster adminMaster) {
		HashMap<String, Object> adminResponse=new HashMap<String, Object>();
		List<UserMaster> adminMasterList;
		try{
			adminResponse=userDAO.getAllAdmin();
			if(adminResponse.get("CODE").equals(Constants.SUCCESS_CODE)){
				adminMasterList=(List<UserMaster>) adminResponse.get("ADMINLIST");
				for(UserMaster am:adminMasterList){
					if(am.getEmail_address().equalsIgnoreCase(adminMaster.getEmail_address())){
						adminResponse.put("CODE", Constants.SUCCESS_CODE);
						adminResponse.put("PASSWORD", am.getPassword());
						break;
					}
					else{
						adminResponse.put("CODE", Constants.ERROR_CODE);
					}
				}
			}
			else{
				adminResponse.put("CODE", Constants.ERROR_CODE);
			}
			return adminResponse;
		}
		catch(Exception e){
			adminResponse.put("CODE", Constants.ERROR_CODE);
			return adminResponse;
		}
		finally{
			adminResponse=null;
			adminMasterList=null;
		}
	}
	
}
