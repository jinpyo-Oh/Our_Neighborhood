package com.kh.bbq_reservation.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.bbq_reservation.model.dao.BbqDao;
import com.kh.bbq_reservation.model.vo.BbqReservation;

import static com.kh.common.JDBCTemplate.*;


public class BbqService {
	
	public ArrayList<String> bbqResSelect(String resDate){
		
		Connection conn = getConnection();
		
		ArrayList<String> list = new BbqDao().bbqResSelect(conn, resDate);
		
		close(conn);
		
		return list;
	}
	
	public int bbqResInsert(BbqReservation bbq) {
		Connection conn = getConnection();
		
		int result = new BbqDao().bbqResInsert(conn, bbq);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
