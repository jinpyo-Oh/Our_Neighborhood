package com.kh.bbq_reservation.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.bbq_reservation.model.vo.BbqReservation;

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
		BbqReservation bbq = null;
		
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
	
	public int bbqResInsert(Connection conn, BbqReservation bbq) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("bbqResInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbq.getResPlace());
			pstmt.setString(2,bbq.getResDate());
			pstmt.setInt(3,bbq.getResPeople());
			pstmt.setString(4, bbq.getResName());
			pstmt.setString(5, bbq.getResMsg());
			pstmt.setInt(6, bbq.getResMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
			
	}
	
	public BbqReservation bbqSelectOne(Connection conn, int memberNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bbqSelectOne");
		BbqReservation bbq = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bbq = new BbqReservation(
						rset.getInt("RES_NO"),
						rset.getInt("RES_PLACE"),
						rset.getString("RES_DATE"),
						rset.getInt("RES_PEOPLE"),
						rset.getString("RES_NAME"),
						rset.getString("RES_MSG")
						) ;
			}			
								
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
		return bbq;
		
	}
	
	public int bbqDelete(Connection conn, int resNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("bbqDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	

}
