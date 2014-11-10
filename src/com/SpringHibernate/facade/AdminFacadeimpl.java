package com.SpringHibernate.facade;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringHibernate.DAO.AdminDAO;
import com.SpringHibernate.model.AdminMaster;
import com.SpringHibernate.util.Constant;

@Service
public class AdminFacadeimpl implements AdminFacade {
	
	@Autowired
	AdminDAO adminDAO;
	
	@Override
	@Transactional
	public HashMap<String, Object> adminAuthendication(AdminMaster adminMaster) {
		return adminDAO.adminAuthendication(adminMaster);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public HashMap<String, Object> getAdminPassword(AdminMaster adminMaster) {
		HashMap<String, Object> adminResponse=new HashMap<String, Object>();
		List<AdminMaster> adminMasterList;
		try{
			adminResponse=adminDAO.getAllAdmin();
			if(adminResponse.get("CODE").equals(Constant.SUCCESS_CODE)){
				adminMasterList=(List<AdminMaster>) adminResponse.get("ADMINLIST");
				for(AdminMaster am:adminMasterList){
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
