package com.kh.bbq_reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

public class BbqDao {
	
	Properties prop = new Properties();
	
	public BbqDao() {
		String fileName = BbqDao.class.getResource("/sql/bbq/bbq-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> bbqResSelect(Connection conn, String resDate){
		
		ArrayList<String> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bbqResSelect");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resDate);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				 list.add(String.valueOf(rset.getInt("RES_PLACE")));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
		
	}
	
	

}
