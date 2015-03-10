package com.edu.myapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.myapp.dao.HomeDao;

@Service
public class HomeServiceImpl implements HomeService {

   @Autowired
   HomeDao homeDao;

    public List<HashMap<String,Object>> selectGearList(
    		Map<String,String> paramMap) throws Exception{
    	
    	List<HashMap<String,Object>> retList = new ArrayList<HashMap<String,Object>>();
    	
    	if(paramMap.get("id")==null || paramMap.get("id").equals("")){
    		retList = homeDao.selectGearList(paramMap);
    	
    	}else{
    		retList = homeDao.selectGearDetailList(paramMap);
    		
    	}
    	
    	return retList;

    }

	@Override
	public int insertGear(
			Map<String, String> paramMap) throws Exception {
		
		return homeDao.insertGear(paramMap);
		
	}

	@Override
	public int deleteGear(
			Map<String, String> paramMap) throws Exception {
	
		return homeDao.deleteGear(paramMap);
	}
	
	

	@Override
	public int updateGear(Map<String, String> paramMap) throws Exception {
		System.out.println("========= updateGear 34444===================");
		return homeDao.updateGear(paramMap);
		
	}

	
}

