package com.kh.bbq_reservation.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.bbq_reservation.model.dao.BbqDao;
import static com.kh.common.JDBCTemplate.*;


public class BbqService {
	
	public ArrayList<String> bbqResSelect(String resDate){
		
		Connection conn = getConnection();
		
		ArrayList<String> list = new BbqDao().bbqResSelect(conn, resDate);
		
		close(conn);
		
		return list;
	}

}
