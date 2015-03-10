package com.edu.myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {

    @Autowired
    private SqlSession sqlSession;

    public List<HashMap<String,Object>> selectGearList(Map<String,String> paramMap) throws Exception{
    	
    	return sqlSession.selectList("home.selectList", paramMap);

    }

	public List<HashMap<String, Object>> selectGearDetailList(Map<String, String> paramMap) throws Exception{
		return sqlSession.selectList("home.selectDetailList", paramMap);
	}
	
	public int insertGear(Map<String, String> paramMap) {
		return sqlSession.insert("home.insertGear", paramMap); 
	}
	
	
	public int deleteGear(Map<String, String> paramMap) {
		return sqlSession.delete("home.deleteGear",paramMap);
	}
	
	
	public int updateGear(Map<String, String> paramMap){
		System.out.println("qqqqqqqqqq");
		return sqlSession.update("home.updateGear",paramMap);
	}
	    
}


