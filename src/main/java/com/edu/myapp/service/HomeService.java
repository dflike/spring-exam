package com.edu.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {
	
	public List<HashMap<String,Object>> selectGearList(Map<String, String> paramMap) throws Exception;
	
	public int insertGear(Map<String, String> paramMap) throws Exception;
	
	public int deleteGear(Map<String, String> delparamMap) throws Exception;

	public int updateGear(Map<String, String> paramMap) throws Exception;
	
	
}
